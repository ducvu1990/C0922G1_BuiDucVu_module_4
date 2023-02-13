package com.codegym.borrow_books.model;

import javax.persistence.*;

@Entity
public class BookLoanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long rentId;

    @ManyToOne
    @JoinColumn(name = "bookId",referencedColumnName = "id")
    private Book book;

    public BookLoanCard() {
    }

    public BookLoanCard(long rentId, Book book) {
        this.rentId = rentId;
        this.book = book;
    }

    public BookLoanCard(int id, long rentId, Book book) {
        this.id = id;
        this.rentId = rentId;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRentId() {
        return rentId;
    }

    public void setRentId(long rentId) {
        this.rentId = rentId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
