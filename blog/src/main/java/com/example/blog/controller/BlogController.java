package com.example.blog.controller;

import com.example.blog.entity.BlogContent;
import com.example.blog.service.IBlogService;
import com.example.blog.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping(value = "")
    public String showBlog(@RequestParam(name = "type", required = false, defaultValue = "1") Integer typeId,
                           Model model){
        model.addAttribute("blogList", blogService.findAllByBlogType_Id(typeId));
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("selectedType", typeId);
        return "blog/home";
    }

    @GetMapping(value = "/blog/detail")
    public String showBlogDetail(@RequestParam(name = "type", required = false) Integer typeId,
                                 @RequestParam(name = "id") int id,
                                 Model model){
        model.addAttribute("blogDetail", blogService.findById(id));
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        var blog = blogService.findById(id);
        Integer selected = (typeId != null) ? typeId : blog.getBlogType() != null ? blog.getBlogType().getId() : null;
        model.addAttribute("selectedType", selected);
        return "blog/blog-detail";
    }

//    @GetMapping(value = "/blog/add")
//    public String showAddBlog(@RequestParam(name = "type", required = false) Integer typeId,
//                              Model model){
//        model.addAttribute("blogList", blogService.findAllByBlogType_Id(typeId));
//        model.addAttribute("blogTypeList", blogTypeService.findAll());
//        model.addAttribute("blog", new BlogContent());
//        model.addAttribute("openAddModal", "true");
//        model.addAttribute("selectedType", typeId);
//        return "blog/blog-add";
//    }

    @GetMapping("/blog/add")
    public String showAddBlog(@RequestParam(name = "type", required = false) Integer typeId,
                              Model model) {
        int resolvedType = (typeId != null) ? typeId : 1;
        model.addAttribute("blogList", blogService.findAllByBlogType_Id(resolvedType));
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("blog", new BlogContent());
        model.addAttribute("openAddModal", true);
        model.addAttribute("selectedType", resolvedType);
        return "blog/blog-add";
    }

    @PostMapping("/blog/add")
    public String addBlog(@ModelAttribute BlogContent blogContent,
                          @RequestParam(name = "type", required = false) Integer typeId){
        blogContent.setBlogType(blogTypeService.findAll().stream().filter(t -> t.getId() == typeId).findFirst().orElse(null));
        blogService.addBlog(blogContent);
        return "redirect:/?type=" + typeId;
    }

    @GetMapping("/blog/edit")
    public String showEditBlog(@RequestParam(name = "type", required = false) Integer typeId,
                               @RequestParam(name = "id") int id,
                               Model model){
        model.addAttribute("blogList", blogService.findAllByBlogType_Id(typeId));
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("openAddModal", true);
        model.addAttribute("selectedType", typeId);
        return "blog/blog-edit";
    }

    @PostMapping("/blog/edit")
    public String editBlog(@ModelAttribute BlogContent blogContent,
                           @RequestParam(name = "type", required = false) Integer typeId){
        blogContent.setBlogType(blogTypeService.findAll().stream().filter(t -> t.getId() == typeId).findFirst().orElse(null));
        blogService.updateBlog(blogContent);
        return "redirect:/?type=" + typeId;
    }
}
