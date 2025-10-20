//package com.example.blog.controller;
//
//import com.example.blog.entity.BlogContent;
//import com.example.blog.service.IBlogService;
//import com.example.blog.service.IBlogTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.data.domain.PageRequest;
//
//import java.util.Optional;
//
//@Controller
//public class BlogController {
//    @Autowired
//    private IBlogService blogService;
//    @Autowired
//    private IBlogTypeService blogTypeService;
//
//    @GetMapping(value = "")
//    public String showBlog(@RequestParam(name = "type", required = false, defaultValue = "1") Integer typeId,
//                           @RequestParam(name="page", required = false, defaultValue = "0") int page,
//                           Model model){
//        Pageable pageable = PageRequest.of(page,9,Sort.by("createdAt").descending());
//        model.addAttribute("blogList", blogService.findAllByBlogType_Id(typeId, pageable));
//        model.addAttribute("blogTypeList", blogTypeService.findAll());
//        model.addAttribute("selectedType", typeId);
//        return "blog/home";
//    }
//
//    @GetMapping(value = "/blog/detail")
//    public String showBlogDetail(@RequestParam(name = "type", required = false) Integer typeId,
//                                 @RequestParam(name = "id") int id,
//                                 Model model){
//        model.addAttribute("blogDetail", blogService.findById(id));
//        model.addAttribute("blogTypeList", blogTypeService.findAll());
//        var blog = blogService.findById(id);
//        Integer selected = (typeId != null) ? typeId : blog.getBlogType() != null ? blog.getBlogType().getId() : null;
//        model.addAttribute("selectedType", selected);
//        return "blog/blog-detail";
//    }
//
//
//    @GetMapping("/blog/add")
//    public String showAddBlog(@RequestParam(name = "type", required = false) Integer typeId,
//                              @RequestParam(name = "page", required = false, defaultValue = "0") int page,
//                              Model model) {
//        Pageable pageable = PageRequest.of(page,9,Sort.by("createdAt").descending());
//        int resolvedType = (typeId != null) ? typeId : 1;
//        model.addAttribute("blogList", blogService.findAllByBlogType_Id(resolvedType,  pageable));
//        model.addAttribute("blogTypeList", blogTypeService.findAll());
//        model.addAttribute("blog", new BlogContent());
//        model.addAttribute("openAddModal", true);
//        model.addAttribute("selectedType", resolvedType);
//        return "blog/blog-add";
//    }
//
//    @PostMapping("/blog/add")
//    public String addBlog(@ModelAttribute BlogContent blogContent,
//                          @RequestParam(name = "type", required = false) Integer typeId){
//        blogContent.setBlogType(blogTypeService.findAll().stream().filter(t -> t.getId() == typeId).findFirst().orElse(null));
//        blogService.addBlog(blogContent);
//        return "redirect:/?type=" + typeId;
//    }
//
//    @GetMapping("/blog/edit")
//    public String showEditBlog(@RequestParam(name = "type", required = false) Integer typeId,
//                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
//                               @RequestParam(name = "id") int id,
//                               Model model){
//        Pageable pageable = PageRequest.of(page,9,Sort.by("createdAt").descending());
//        model.addAttribute("blogList", blogService.findAllByBlogType_Id(typeId, pageable));
//        model.addAttribute("blogTypeList", blogTypeService.findAll());
//        model.addAttribute("blog", blogService.findById(id));
//        model.addAttribute("openAddModal", true);
//        model.addAttribute("selectedType", typeId);
//        return "blog/blog-edit";
//    }
//
//    @PostMapping("/blog/edit")
//    public String editBlog(@ModelAttribute BlogContent blogContent,
//                          @RequestParam(name = "type", required = false) Integer typeId){
//        blogContent.setBlogType(blogTypeService.findAll().stream().filter(t -> t.getId() == typeId).findFirst().orElse(null));
//        blogService.addBlog(blogContent);
//        return "redirect:/?type=" + typeId;
//    }
//
//    @PostMapping("/blog/delete")
//    public String deleteBlog(@RequestParam(name = "type", required = false) Integer typeId,
//                             @RequestParam(name = "page", required = false, defaultValue = "0") int page,
//                             @RequestParam(name = "id") int id,
//                             Model model){
//        Pageable pageable = PageRequest.of(page,9,Sort.by("createdAt").descending());
//        blogService.deleteBlogById(id);
//        model.addAttribute("blogList", blogService.findAllByBlogType_Id(typeId, pageable));
//        model.addAttribute("blogTypeList", blogTypeService.findAll());
//        model.addAttribute("selectedType", typeId);
//        return "blog/home";
//    }
//
//    @GetMapping("/blog/search")
//    public String showSearchBlog(@RequestParam(name = "type", required = false) Integer typeId,
//                                 @RequestParam(name = "page", required = false, defaultValue = "0") int page,
//                                 @RequestParam(name = "search") String search,
//                                 Model model){
//        Pageable pageable = PageRequest.of(page,9,Sort.by("createdAt").descending());
//        int resolvedType = (typeId != null) ? typeId : 1;
//        model.addAttribute("blogList", blogService.findAllByBlogType_IdAndTitleContaining(resolvedType, search, pageable));
//        model.addAttribute("blogTypeList", blogTypeService.findAll());
//        model.addAttribute("selectedType", typeId);
//        return "blog/home";
//    }
//}


package com.example.blog.controller;

import com.example.blog.dto.BlogContentdto;
import com.example.blog.entity.BlogContent;
import com.example.blog.service.IBlogService;
import com.example.blog.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogTypeService blogTypeService;

    // Trang chủ hiển thị danh sách blog theo type
    @GetMapping("")
    public String showBlog(@RequestParam(name = "type", required = false) Integer typeId,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           Model model) {

        int resolvedType = resolveTypeId(typeId);
        Pageable pageable = PageRequest.of(page, 9, Sort.by("createdAt").descending());

        Page<BlogContentdto> blogPage = blogService.findAllByBlogType_Id(resolvedType, pageable);

        model.addAttribute("blogList", blogPage);
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("selectedType", resolvedType);
        return "blog/home";
    }

    // Trang chi tiết blog
    @GetMapping("/blog/detail")
    public String showBlogDetail(@RequestParam(name = "type", required = false) Integer typeId,
                                 @RequestParam(name = "id") int id,
                                 Model model) {

        BlogContentdto blog = blogService.findById(id);
        Integer selected = (typeId != null) ? typeId : blog.getTypeId();

        model.addAttribute("blogDetail", blog);
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("selectedType", selected);
        return "blog/blog-detail";
    }

    // Form thêm blog
    @GetMapping("/blog/add")
    public String showAddBlog(@RequestParam(name = "type", required = false) Integer typeId,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              Model model) {

        int resolvedType = resolveTypeId(typeId);
        Pageable pageable = PageRequest.of(page, 9, Sort.by("createdAt").descending());

        model.addAttribute("blogList", blogService.findAllByBlogType_Id(resolvedType, pageable));
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("blog", new BlogContentdto());
        model.addAttribute("openAddModal", true);
        model.addAttribute("selectedType", resolvedType);
        return "blog/blog-add";
    }

    // Xử lý thêm blog
    @PostMapping("/blog/add")
    public String addBlog(@ModelAttribute BlogContentdto blogDto,
                          @RequestParam(name = "type", required = false) Integer typeId) {

        blogDto.setTypeId(resolveTypeId(typeId));
        blogService.addBlog(blogDto);
        return "redirect:/?type=" + blogDto.getTypeId();
    }

    // Form sửa blog
    @GetMapping("/blog/edit")
    public String showEditBlog(@RequestParam(name = "type", required = false) Integer typeId,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "id") int id,
                               Model model) {

        int resolvedType = resolveTypeId(typeId);
        Pageable pageable = PageRequest.of(page, 9, Sort.by("createdAt").descending());

        model.addAttribute("blogList", blogService.findAllByBlogType_Id(resolvedType, pageable));
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("openAddModal", true);
        model.addAttribute("selectedType", resolvedType);
        return "blog/blog-edit";
    }

    // Xử lý sửa blog
    @PostMapping("/blog/edit")
    public String editBlog(@ModelAttribute BlogContentdto blogDto,
                           @RequestParam(name = "type", required = false) Integer typeId) {

        blogDto.setTypeId(resolveTypeId(typeId));
        blogService.updateBlog(blogDto);
        return "redirect:/?type=" + blogDto.getTypeId();
    }

    // Xóa blog
    @PostMapping("/blog/delete")
    public String deleteBlog(@RequestParam(name = "type", required = false) Integer typeId,
                             @RequestParam(name = "id") int id) {

        blogService.deleteBlogById(id);
        return "redirect:/?type=" + resolveTypeId(typeId);
    }

    // Tìm kiếm blog theo title
    @GetMapping("/blog/search")
    public String showSearchBlog(@RequestParam(name = "type", required = false) Integer typeId,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "search") String search,
                                 Model model) {

        int resolvedType = resolveTypeId(typeId);
        Pageable pageable = PageRequest.of(page, 9, Sort.by("createdAt").descending());

        model.addAttribute("blogList", blogService.findAllByBlogType_IdAndTitleContaining(resolvedType, search, pageable));
        model.addAttribute("blogTypeList", blogTypeService.findAll());
        model.addAttribute("selectedType", resolvedType);
        return "blog/home";
    }

    // Helper: lấy typeId mặc định
    private int resolveTypeId(Integer typeId) {
        return (typeId != null) ? typeId : 1;
    }
}
