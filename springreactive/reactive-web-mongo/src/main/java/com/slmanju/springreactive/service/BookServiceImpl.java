package com.slmanju.springreactive.service;

import com.slmanju.springreactive.repository.Book;
import com.slmanju.springreactive.repository.ReactiveBookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {
    
    private final ReactiveBookRepository reactiveBookRepository;

    public BookServiceImpl(ReactiveBookRepository reactiveBookRepository) {
        this.reactiveBookRepository = reactiveBookRepository;
    }

    @Override
    public Mono<Book> save(Book book) {
        return reactiveBookRepository.save(book);
    }

    @Override
    public Mono<Book> find(String id) {
        return reactiveBookRepository.findById(id);
    }

    @Override
    public Flux<Book> findAll() {
        return reactiveBookRepository.findAll();
    }

}
