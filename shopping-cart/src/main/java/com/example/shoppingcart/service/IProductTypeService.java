package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.ProductType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAllProductTypes();
    ProductType findProductTypeById(int id);
}
