package com.example.product_data_management.repository.impl;

import com.example.product_data_management.model.Product;
import com.example.product_data_management.repository.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        productList = entityManager.createQuery("select p from Product as p").getResultList();
        return productList;
    }

    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public void update(int id, Product product) {
        Product product1 = findById(id);
        product1.setName(product.getName());
        product1.setBrand(product.getBrand());
        product1.setPrice(product.getPrice());
        entityManager.merge(product1);
    }

    @Transactional
    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> search(String names) {
        List<Product> productList = null;
        productList = entityManager.createQuery("select p from Product as p where p.name like: names").
                setParameter("names", "%" + names + "%").getResultList();
        return productList;
    }
}
