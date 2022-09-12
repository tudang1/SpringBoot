package com.heaven.web.service;

import com.heaven.web.model.Book;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();
    Book create(Book book);
    Optional<Book> find(String isbn);
}
