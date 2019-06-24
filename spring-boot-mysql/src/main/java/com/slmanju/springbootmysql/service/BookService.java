package com.slmanju.springbootmysql.service;

import com.slmanju.springbootmysql.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Integer id);

    Book save(Book book);

    void delete(Integer id);

    Book update(Book book);

}
