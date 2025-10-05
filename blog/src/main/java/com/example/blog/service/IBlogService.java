package com.example.blog.service;

import com.example.blog.entity.BlogContent;

import java.util.List;

public interface IBlogService {
    List<BlogContent> findAllByBlogType_Id(int blogTypeId);
    BlogContent findById(int id);
    boolean addBlog(BlogContent blogContent);
    boolean updateBlog(BlogContent blogContent);
    boolean deleteBlogById(int id);
}
