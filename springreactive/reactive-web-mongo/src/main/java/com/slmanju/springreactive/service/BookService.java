package com.slmanju.springreactive.service;

import com.slmanju.springreactive.repository.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    
    Mono<Book> save(Book book);
    
    Mono<Book> find(String id);

    Flux<Book> findAll();
    
}
