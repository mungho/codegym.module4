package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.ProductType;
import com.example.shoppingcart.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAllProductTypes() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findProductTypeById(int id) {
        return productTypeRepository.findProductTypeById(id);
    }
}
