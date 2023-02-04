package com.example.product_data_management.service.impl;

import com.example.product_data_management.model.Product;
import com.example.product_data_management.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"iphone","apple",1000));
        products.put(2, new Product(2,"sony","sony",1500));
        products.put(3, new Product(3,"lenovo","lenovo",1100));
        products.put(4, new Product(4,"huawei","trungQuoc",900));
        products.put(5, new Product(5,"oppo","apple",1000));
        products.put(6, new Product(6,"galaxy","samsung",1000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry: products.entrySet()){
            if (entry.getValue().getName().equals(name)){
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
}
