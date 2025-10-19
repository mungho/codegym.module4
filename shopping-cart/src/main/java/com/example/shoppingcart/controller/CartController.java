package com.example.shoppingcart.controller;

import com.example.shoppingcart.dto.CartItem;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.service.IProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IProductService productService;

    /**
     * Thêm sản phẩm vào giỏ hàng bằng AJAX
     * @param id id sản phẩm
     * @param session session của user
     * @return JSON {success, totalItems, totalPrice}
     */
    @PostMapping("/add-ajax/{id}")
    @ResponseBody
    public Map<String, Object> addToCartAjax(@PathVariable int id, HttpSession session) {

        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new HashMap<>();

        // Lấy sản phẩm trực tiếp
        Product product = productService.findProductById(id);
        if (product == null) {
            return Map.of("success", false);
        }

        cart.compute(id, (key, item) -> {
            if (item == null) return new CartItem(product, 1);
            item.setQuantity(item.getQuantity() + 1);
            return item;
        });

        session.setAttribute("cart", cart);

        int totalItems = cart.values().stream().mapToInt(CartItem::getQuantity).sum();
        BigDecimal totalPrice = cart.values().stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Map.of(
                "success", true,
                "totalItems", totalItems,
                "totalPrice", totalPrice
        );
    }

    @GetMapping("")
    public String showCart(Model model, HttpSession session) {
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Your cart is empty.");
            model.addAttribute("total", 0);
            return "layout/cart";
        }

        double total = cart.values().stream()
                .map(CartItem::getTotalPrice)
                .mapToDouble(totalPrice -> totalPrice.doubleValue())
                .sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "layout/cart";
    }


}
