package com.codegym.borrow_books.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<BookLoanCard> bookLoanCards;

    public Book() {
    }


    public Book(int id, String name, int quantity, Set<BookLoanCard> bookLoanCards) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.bookLoanCards = bookLoanCards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<BookLoanCard> getBookLoanCards() {
        return bookLoanCards;
    }

    public void setBookLoanCards(Set<BookLoanCard> bookLoanCards) {
        this.bookLoanCards = bookLoanCards;
    }
}
