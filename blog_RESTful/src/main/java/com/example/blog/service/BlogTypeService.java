package com.example.blog.service;

import com.example.blog.entity.BlogType;
import com.example.blog.repository.IBlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeService implements IBlogTypeService{
    @Autowired
    private IBlogTypeRepository blogTypeRepository;

    @Override
    public List<BlogType> findAll() {
        return blogTypeRepository.findAll();
    }
}
