package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.service.IBlogService;
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
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<Page<Blog>> getAll(@RequestParam(required = false,defaultValue = "") String name,
                                             @RequestParam(required = false,defaultValue = "0") int page,
                                             @RequestParam(required = false,defaultValue = "0") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Blog> blogPage = blogService.search(name, pageable);
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/blog")
    public ResponseEntity<Blog> findBlog(@RequestParam(required = false,defaultValue = "0") int id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<Page<Blog>> getAllOfCategory(@RequestParam(required = false,defaultValue = "0") int id,
                                                       @RequestParam(required = false,defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> blogPage = blogService.findByCategoryId(id, pageable);

        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
