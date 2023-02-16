package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<Page<Category>> getAllCategory(@RequestParam(required = false,defaultValue = "") String name,
                                                         @RequestParam(required = false,defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 2);
        Page<Category> categoryPage = categoryService.search(name, pageable);
        if (categoryPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }
}
