package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.ProductType;
import com.example.shoppingcart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findAllProducts(int productType, Pageable pageable) {
        if (productType == 0) {
            return productRepository.findAll(pageable);
        }
        return productRepository.findProductByProductType_Id(productType, pageable);
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id).get();
    }
}
