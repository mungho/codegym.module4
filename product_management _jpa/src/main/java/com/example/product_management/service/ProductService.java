package com.example.product_management.service;

import com.example.product_management.entity.Product;
import com.example.product_management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public boolean addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
