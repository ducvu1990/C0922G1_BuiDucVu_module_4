package com.codegym.borrow_books.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    private int count=0;
    private int count1=0;
    @Pointcut("execution(* com.codegym.borrow_books.controller.BookController.payBook(..))||execution(* com." +
            "codegym.borrow_books.controller.BookController.rent(..))")
    public void getAllRentBook(){
    }
    @AfterReturning(value = "getAllRentBook()")
    public void print(){
        count++;
        System.out.println("số lần khiến trạng thái sách của thư viện bị thay đổi là: " + count);
    }
    @Pointcut("execution(* com.codegym.borrow_books.controller.BookController.*(..))")
    public void getAllManipulating(){
    }
    @After(value = "getAllManipulating()")
    public void print1(){
        count1++;
        System.out.println("số lượng người đã ghé thăm thư viện sách là: " + count1);
    }
}
