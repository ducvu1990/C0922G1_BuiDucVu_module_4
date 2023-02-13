package com.codegym.borrow_books.controller;

import com.codegym.borrow_books.model.Book;
import com.codegym.borrow_books.model.BookLoanCard;
import com.codegym.borrow_books.service.IBookLoanCarService;
import com.codegym.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookLoanCarService bookLoanCarService;
    @GetMapping()
    public String showList(Model model){
        model.addAttribute("books", bookService.findAllBook());
        return "list";
    }
    @GetMapping("/{id}/rent")
    public String showFormRent(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        Book book = bookService.findById(id);
        if (book.getQuantity() !=0){
            model.addAttribute("book", book);
            return "rent";
        }
        redirectAttributes.addFlashAttribute("messages", "This book has been lent out");
        return "redirect:/book";
    }
    @PostMapping("/rent")
    public String rent(@ModelAttribute Book book, Model model){

        BookLoanCard bookLoanCard = new BookLoanCard((int) (Math.random()*100000),book);
        bookLoanCarService.save(bookLoanCard);
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);

        model.addAttribute("book", book);
        model.addAttribute("bookLoanCard",bookLoanCard.getRentId());
        return "rentId";
    }
    @GetMapping("/listBookloanCard")
    public String showListBookLoanCard(Model model){
        model.addAttribute("bookLoanCard", bookLoanCarService.findAllBookLoanCar());
        return "listCard";
    }
    @GetMapping("pay")
    public String pay(){
        return "pay";
    }
    @GetMapping("/payBook")
    public String payBook(@RequestParam(required = false,defaultValue = "0") long renId, RedirectAttributes redirectAttributes){
        List<BookLoanCard> bookLoanCardList = bookLoanCarService.findAllBookLoanCar();
        for (BookLoanCard item :bookLoanCardList) {
            if (item.getRentId() == renId){
                Book book = bookService.findById(item.getBook().getId());
                book.setQuantity(book.getQuantity()+1);
                bookService.update(book);
                bookLoanCarService.remove(item);
                redirectAttributes.addFlashAttribute("message", "return book successfully");
                    return "redirect:/book";
            }
        }
        redirectAttributes.addFlashAttribute("message", "the return code is not correct");
        return "redirect:/book";
    }
    @GetMapping("/create")
    public String createBook(Model model){
        model.addAttribute("book",new Book());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Book book, RedirectAttributes attributes){
        bookService.save(book);
        attributes.addFlashAttribute("messages", "Add new successfully");
        return "redirect:/book";
    }
}
