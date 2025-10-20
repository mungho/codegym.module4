package com.example.blog.service;

import com.example.blog.dto.BlogContentdto;
import com.example.blog.entity.BlogContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<BlogContentdto> findAllByBlogType_Id(int blogTypeId, Pageable pageable);
    BlogContentdto findById(int id);
    boolean addBlog(BlogContentdto blogContent);
    boolean updateBlog(BlogContentdto blogContent);
    boolean deleteBlogById(int id);
    Page<BlogContentdto> findAllByBlogType_IdAndTitleContaining(int blogTypeId, String title, Pageable pageable);
    List<BlogContentdto> findAll();
}
