package com.example.blog.service;

import com.example.blog.entity.BlogContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<BlogContent> findAllByBlogType_Id(int blogTypeId, Pageable pageable);
    BlogContent findById(int id);
    boolean addBlog(BlogContent blogContent);
    boolean updateBlog(BlogContent blogContent);
    boolean deleteBlogById(int id);
    Page<BlogContent> findAllByBlogType_IdAndTitleContaining(int blogTypeId, String title, Pageable pageable);
}
