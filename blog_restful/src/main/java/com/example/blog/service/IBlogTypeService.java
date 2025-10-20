package com.example.blog.service;

import com.example.blog.dto.BlogTypedto;
import com.example.blog.entity.BlogType;

import java.util.List;

public interface IBlogTypeService {
    List<BlogTypedto> findAll();
}
