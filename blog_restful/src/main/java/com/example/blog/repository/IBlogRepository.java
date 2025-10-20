package com.example.blog.repository;

import com.example.blog.entity.BlogContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogContent, Integer> {

    Page<BlogContent> findAllByBlogType_Id(int blogTypeId, Pageable pageable);
    Page<BlogContent> findAllByBlogType_IdAndTitleContaining(Integer blogTypeId, String title, Pageable pageable);
}
