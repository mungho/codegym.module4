package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository bookRepository;

    @Override
    public Page<Book> getBooks(int type, Pageable pageable) {
        return bookRepository.findAllbyCategory(type, pageable);
    }

    @Override
    public boolean borrowBook(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.getAmount() > 0) {
                book.setAmount(book.getAmount() - 1);
                bookRepository.save(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(String code) {
        return false;
    }
}
