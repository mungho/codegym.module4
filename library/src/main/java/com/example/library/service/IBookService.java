package com.example.library.service;

import org.springframework.data.domain.Page;

public interface IBookService {
    Page<String> getBooks();
    boolean borrowBook(String code);
    boolean returnBook(String code);
}
