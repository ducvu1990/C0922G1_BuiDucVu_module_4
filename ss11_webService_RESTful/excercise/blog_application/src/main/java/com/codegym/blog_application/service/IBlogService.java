package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> search(String name, Pageable pageable);
List<Blog> findAll();
void save(Blog blog);
Blog findById(int id);
void update(Blog blog);
void remove(Blog blog);
Page<Blog> findByCategoryId(int id, Pageable pageable);
}
