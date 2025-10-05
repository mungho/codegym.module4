package com.example.blog.service;

import com.example.blog.entity.BlogContent;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<BlogContent> findAllByBlogType_Id(int blogTypeId) {
        return blogRepository.findAllByBlogType_Id(blogTypeId);
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
}
