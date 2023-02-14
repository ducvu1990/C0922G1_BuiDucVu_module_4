package com.codagym.add_product_to_cart.service.impl;

import com.codagym.add_product_to_cart.model.Product;
import com.codagym.add_product_to_cart.repository.IProductRepository;
import com.codagym.add_product_to_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
