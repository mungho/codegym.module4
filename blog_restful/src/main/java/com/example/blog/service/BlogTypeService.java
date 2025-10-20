package com.example.blog.service;

import com.example.blog.dto.BlogContentdto;
import com.example.blog.dto.BlogTypedto;
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
    public List<BlogTypedto> findAll() {
        List<BlogType> types = blogTypeRepository.findAll(); // Lấy tất cả entity
        return types.stream()
                .map(type -> new BlogTypedto(
                        type.getId(),
                        type.getName() // chỉ lấy id và name
                ))
                .toList();
    }

}
