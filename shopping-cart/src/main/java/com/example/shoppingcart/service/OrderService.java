package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Order;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public boolean addProduct(Order order) {
       Order savedOrder = orderRepository.save(order);
       return savedOrder != null;
    }

    @Override
    public boolean removeProduct(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
