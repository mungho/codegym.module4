package com.example.blog.service;

import com.example.blog.entity.BlogContent;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<BlogContent> findAllByBlogType_Id(int blogTypeId, Pageable pageable) {
        return blogRepository.findAllByBlogType_Id(blogTypeId,pageable);
    }

    @Override
    public BlogContent findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addBlog(BlogContent blogContent) {
        return blogRepository.save(blogContent) != null;
    }

    @Override
    public boolean updateBlog(BlogContent blogContent) {
        return blogRepository.save(blogContent) != null;
    }

    @Override
    public boolean deleteBlogById(int id) {
        try{
            blogRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page<BlogContent> findAllByBlogType_IdAndTitleContaining(int blogTypeId, String title, Pageable pageable) {
        return blogRepository.findAllByBlogType_IdAndTitleContaining(blogTypeId, title, pageable);
    }

}
