package com.codegym.borrow_books.service;

import com.codegym.borrow_books.model.BookLoanCard;

import java.util.List;

public interface IBookLoanCarService {
    List<BookLoanCard> findAllBookLoanCar();

    void save(BookLoanCard bookLoanCard);

    void update(BookLoanCard bookLoanCard);

    BookLoanCard findById(int id);

    void remove(BookLoanCard bookLoanCard);
}
