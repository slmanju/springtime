package com.slmanju.springreactive.reactiveweb.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    
    Mono<Book> save(Book book);
    
    Mono<Book> find(String id);

    Flux<Book> findAll();
    
}
