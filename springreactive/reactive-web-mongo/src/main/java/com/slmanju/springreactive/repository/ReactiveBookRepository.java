package com.slmanju.springreactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveBookRepository extends ReactiveCrudRepository<Book, String> {
}
