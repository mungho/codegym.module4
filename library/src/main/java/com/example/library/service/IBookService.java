package com.example.library.service;

import com.example.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> getBooks(int type, Pageable pageable);
    boolean borrowBook(String code);
    boolean returnBook(String code);
}
