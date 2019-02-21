package com.slmanju.springreactive.controller;

import com.slmanju.springreactive.repository.Book;
import com.slmanju.springreactive.service.BookService;
import org.springframework.web.bind.annotation.*;
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
