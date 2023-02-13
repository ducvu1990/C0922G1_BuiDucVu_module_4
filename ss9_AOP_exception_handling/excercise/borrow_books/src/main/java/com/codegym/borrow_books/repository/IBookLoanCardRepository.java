package com.codegym.borrow_books.repository;

import com.codegym.borrow_books.model.BookLoanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookLoanCardRepository extends JpaRepository<BookLoanCard,Integer> {
}
