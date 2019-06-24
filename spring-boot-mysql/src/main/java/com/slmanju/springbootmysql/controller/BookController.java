package com.slmanju.springbootmysql.controller;

import com.slmanju.springbootmysql.domain.Book;
import com.slmanju.springbootmysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Book findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.save(book);
    }

}
