package com.example.library.controller;

import com.example.library.service.IBookService;
import com.example.library.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String home(Model model,
                       @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                       @RequestParam(name = "type", required = false, defaultValue = "1") int type) {
        Pageable pageable = PageRequest.of(page,9, Sort.by("id").descending());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("books", bookService.getBooks(type, pageable));
        model.addAttribute("type", type);
        return "layout/home";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam(name = "bookId") int bookId, Model model) {

    }
}
