package com.example.blog.repository;

import com.example.blog.entity.BlogContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogContent, Integer> {

    List<BlogContent> findAllByBlogType_Id(int blogTypeId);
}
