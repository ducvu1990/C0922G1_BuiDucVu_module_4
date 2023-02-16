package com.codegym.blog_application.service.impl;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.repository.IBlogRepository;
import com.codegym.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name,pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
       blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findByCategoryId(int id, Pageable pageable) {
        return blogRepository.findByCategory_Id(id,pageable);
    }
}
