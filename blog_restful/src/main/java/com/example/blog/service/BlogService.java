package com.example.blog.service;

import com.example.blog.dto.BlogContentdto;
import com.example.blog.entity.BlogContent;
import com.example.blog.entity.BlogType;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.repository.IBlogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private IBlogTypeRepository blogTypeRepository;

    @Override
    public Page<BlogContentdto> findAllByBlogType_Id(int blogTypeId, Pageable pageable) {
        return blogRepository.findAllByBlogType_Id(blogTypeId, pageable)
                .map(e -> {
                    BlogContentdto dto = new BlogContentdto();
                    dto.setId(e.getId());
                    dto.setTitle(e.getTitle());
                    dto.setMetadata(e.getMetadata());
                    dto.setContent(e.getContent());
                    dto.setAuthor(e.getAuthor());
                    dto.setCreatedAt(e.getCreatedAt());
                    dto.setLastUpdatedAt(e.getLastUpdatedAt());
                    dto.setTypeId(e.getBlogType().getId());
                    return dto;
                });
    }


    @Override
    public BlogContentdto findById(int id) {
        return blogRepository.findById(id)
                .map(e -> new BlogContentdto(
                        e.getId(),
                        e.getTitle(),
                        e.getMetadata(),
                        e.getContent(),
                        e.getAuthor(),
                        e.getCreatedAt(),
                        e.getLastUpdatedAt(),
                        e.getBlogType().getId()
                ))
                .orElse(null);
    }

    @Override
    public boolean addBlog(BlogContentdto dto) {
        BlogType blogType = blogTypeRepository.findById(dto.getTypeId()).orElse(null);
        if (blogType == null) return false;

        BlogContent entity = new BlogContent();
        entity.setTitle(dto.getTitle());
        entity.setMetadata(dto.getMetadata());
        entity.setContent(dto.getContent());
        entity.setAuthor(dto.getAuthor());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setLastUpdatedAt(dto.getLastUpdatedAt());
        entity.setBlogType(blogType);

        return blogRepository.save(entity) != null;
    }

    @Override
    public boolean updateBlog(BlogContentdto dto) {
        BlogContent existing = blogRepository.findById(dto.getId()).orElse(null);
        if (existing == null) {
            return false;
        }
        BlogType blogType = blogTypeRepository.findById(dto.getTypeId()).orElse(null);
        if (blogType == null) {
            return false;
        }
        existing.setTitle(dto.getTitle());
        existing.setMetadata(dto.getMetadata());
        existing.setContent(dto.getContent());
        existing.setAuthor(dto.getAuthor());
        existing.setCreatedAt(dto.getCreatedAt());
        existing.setLastUpdatedAt(dto.getLastUpdatedAt());
        existing.setBlogType(blogType);

        return blogRepository.save(existing) != null;
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
    public Page<BlogContentdto> findAllByBlogType_IdAndTitleContaining(int blogTypeId, String title, Pageable pageable) {
        return blogRepository.findAllByBlogType_IdAndTitleContaining(blogTypeId, title, pageable)
                .map(e -> new BlogContentdto(
                        e.getId(),
                        e.getTitle(),
                        e.getMetadata(),
                        e.getContent(),
                        e.getAuthor(),
                        e.getCreatedAt(),
                        e.getLastUpdatedAt(),
                        e.getBlogType().getId()
                ));
    }

    @Override
    public List<BlogContentdto> findAll() {
        List<BlogContent> blogs = blogRepository.findAll(); // lấy tất cả entity
        return blogs.stream()
                .map(blog -> new BlogContentdto(
                        blog.getId(),
                        blog.getTitle(),
                        blog.getMetadata(),
                        blog.getContent(),
                        blog.getAuthor(),
                        blog.getCreatedAt(),
                        blog.getLastUpdatedAt(),
                        blog.getBlogType() != null ? blog.getBlogType().getId() : 0
                ))
                .toList();
    }

}
