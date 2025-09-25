package com.example.product_management.controller;

import com.example.product_management.entity.Product;
import com.example.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "product") Product product,
                      RedirectAttributes redirectAttributes){
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("mess","add success");
        return "redirect:/product/list";
    }

}
