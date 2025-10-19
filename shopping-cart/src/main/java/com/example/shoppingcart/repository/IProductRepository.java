package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findProductByProductType(ProductType productType, Pageable pageable);

    Page<Product> findProductByProductType_Id(int productTypeId, Pageable pageable);
}
