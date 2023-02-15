package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(int id);
    void update(Category category);
    void remove(Category category);
    Page<Category> search(String name, Pageable pageable);
}
