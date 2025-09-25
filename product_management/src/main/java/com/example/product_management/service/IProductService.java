package com.example.product_management.service;

import com.example.product_management.entity.Product;

import java.util.List;

public interface IProductService {
    boolean addProduct(Product product);
    boolean deleteProduct(int id);
    boolean updateProduct(Product product);
    Product getProductById(int id);
    Product findProductById(String name);
    List<Product> getAllProducts();
}
