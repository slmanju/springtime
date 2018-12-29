package com.slmanju.springreactive.reactiveweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {
    
    private List<Book> books = new ArrayList<>();

    @Override
    public Mono<Book> save(Book book) {
        book.setId(UUID.randomUUID().toString());
        books.add(book);
        return Mono.just(book);
    }

    @Override
    public Mono<Book> find(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findAny()
                .map(book -> Mono.just(book))
                .orElse(Mono.empty());
    }

    @Override
    public Flux<Book> findAll() {
        return Flux.fromIterable(books);
    }

}
