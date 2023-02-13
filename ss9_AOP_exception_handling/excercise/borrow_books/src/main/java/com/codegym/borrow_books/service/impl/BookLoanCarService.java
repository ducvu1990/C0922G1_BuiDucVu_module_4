package com.codegym.borrow_books.service.impl;

import com.codegym.borrow_books.model.BookLoanCard;
import com.codegym.borrow_books.repository.IBookLoanCardRepository;
import com.codegym.borrow_books.service.IBookLoanCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanCarService implements IBookLoanCarService {
    @Autowired
    private IBookLoanCardRepository bookLoanCardRepository;

    @Override
    public List<BookLoanCard> findAllBookLoanCar() {
        return bookLoanCardRepository.findAll();
    }

    @Override
    public void save(BookLoanCard bookLoanCard) {
        bookLoanCardRepository.save(bookLoanCard);
    }

    @Override
    public void update(BookLoanCard bookLoanCard) {
        bookLoanCardRepository.save(bookLoanCard);
    }

    @Override
    public BookLoanCard findById(int id) {
        return bookLoanCardRepository.findById(id).get();
    }

    @Override
    public void remove(BookLoanCard bookLoanCard) {
        bookLoanCardRepository.delete(bookLoanCard);
    }
}
