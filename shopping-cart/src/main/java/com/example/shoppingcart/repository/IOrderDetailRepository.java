package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
