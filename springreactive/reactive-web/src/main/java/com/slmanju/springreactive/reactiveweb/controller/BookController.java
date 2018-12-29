package com.slmanju.springreactive.reactiveweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slmanju.springreactive.reactiveweb.service.Book;
import com.slmanju.springreactive.reactiveweb.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = { "", "/" })
    public Flux<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> getBook(@PathVariable String id) {
        return bookService.find(id);
    }

    @PostMapping
    public Mono<Book> save(@RequestBody Book book) {
        return bookService.save(book);
    }

}
