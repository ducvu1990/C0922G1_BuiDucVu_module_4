package com.codegym.borrow_books.service;

import com.codegym.borrow_books.model.Book;
import com.codegym.borrow_books.model.BookLoanCard;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();

    void save(Book book);

    void update(Book book);

    Book findById(int id);

    void remove(Book book);
}
