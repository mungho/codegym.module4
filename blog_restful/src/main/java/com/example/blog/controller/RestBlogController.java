package com.example.blog.controller;

import com.example.blog.dto.BlogContentdto;
import com.example.blog.dto.BlogTypedto;
import com.example.blog.entity.BlogType;
import com.example.blog.service.IBlogService;
import com.example.blog.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("")
    public ResponseEntity<Page<BlogContentdto>> showBlog(@RequestParam(name = "type", required = false) Integer typeId,
                                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                                  Model model) {

        int resolvedType = resolveTypeId(typeId);
        Pageable pageable = PageRequest.of(page, 9, Sort.by("createdAt").descending());

        Page<BlogContentdto> blogPage = blogService.findAllByBlogType_Id(resolvedType, pageable);
        return ResponseEntity.ok(blogPage);
    }
    private int resolveTypeId(Integer typeId) {
        return (typeId != null) ? typeId : 1;
    }

    @GetMapping("/detail")
    public ResponseEntity<BlogContentdto> getBlogById(@RequestParam(name = "id") int id) {
        BlogContentdto blog = blogService.findById(id);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlogContentdto>> getAllBlogs() {
        List<BlogContentdto> blogs = blogService.findAll();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/types")
    public ResponseEntity<List<BlogTypedto>> getAllTypes() {
        List<BlogTypedto> blogTypes = blogTypeService.findAll();
        return ResponseEntity.ok(blogTypes);
    }
}
