package com.codegym.blog_application.service.impl;

import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.repository.ICategoryRepository;
import com.codegym.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Category category) {
        categoryRepository.deleteById(category.getId());
    }

    @Override
    public Page<Category> search(String name, Pageable pageable) {
        return categoryRepository.findByNameContaining(name, pageable);
    }
}
