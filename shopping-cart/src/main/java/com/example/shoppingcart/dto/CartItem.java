package com.example.shoppingcart.dto;

import com.example.shoppingcart.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;
    public BigDecimal getTotalPrice() {
        return BigDecimal.valueOf(product.getPrice())
                .multiply(BigDecimal.valueOf(quantity));
    }
}
