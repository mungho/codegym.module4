package com.example.shoppingcart.controller;

import com.example.shoppingcart.repository.IOrderDetailRepository;
import com.example.shoppingcart.service.IOrderService;
import com.example.shoppingcart.service.IProductService;
import com.example.shoppingcart.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Autowired
    private IProductService productService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("")
    private String redirect() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String showProducts(Model model,
                                @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(name = "categoryId", required = false, defaultValue = "1") Integer selectedType) {
        Pageable pageable = PageRequest.of(page,9, Sort.by("id").descending());
        model.addAttribute("categories", productTypeService.findAllProductTypes());
        model.addAttribute("selectedCategory", productTypeService.findProductTypeById(selectedType));
        model.addAttribute("products", productService.findAllProducts(
                selectedType == null ? 0 : selectedType, pageable));
        return "layout/list";
    }

    @GetMapping("/products/detail")
    public String showProductDetails(@RequestParam("id") int productId, Model model) {
        model.addAttribute("product", productService.findProductById(productId));
        return "layout/detail";
    }
}
