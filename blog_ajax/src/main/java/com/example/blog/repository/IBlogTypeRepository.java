package com.example.blog.repository;

import com.example.blog.entity.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogTypeRepository extends JpaRepository<BlogType, Integer>{
}
