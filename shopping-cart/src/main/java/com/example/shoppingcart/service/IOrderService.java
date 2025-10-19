package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Order;
import com.example.shoppingcart.entity.Product;
import org.springframework.stereotype.Service;

public interface IOrderService {
    boolean addProduct(Order order);
    boolean removeProduct(int id);
}
