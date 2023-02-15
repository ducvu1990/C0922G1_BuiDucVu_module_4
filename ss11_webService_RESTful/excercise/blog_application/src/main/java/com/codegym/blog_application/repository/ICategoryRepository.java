package com.codegym.blog_application.repository;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findByNameContaining(String name, Pageable pageable);
}
