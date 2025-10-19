package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProducts(int productType, Pageable pageable);
    Product findProductById(int id);
}
