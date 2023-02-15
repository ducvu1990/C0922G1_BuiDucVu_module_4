//package com.codegym.blog_application.controller;
//
//import com.codegym.blog_application.model.Blog;
//import com.codegym.blog_application.service.IBlogService;
//import com.codegym.blog_application.service.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//
//@Controller
//@RequestMapping("/blog")
//public class BlogController {
//    @Autowired
//    private IBlogService blogService;
//    @Autowired
//    private ICategoryService categoryService;
//
//    @GetMapping("")
//    public String ListBlog(@RequestParam(required = false, defaultValue = "") String name, Model model,
//                           @RequestParam(required = false, defaultValue = "0") int page) {
//        Pageable pageable = PageRequest.of(page, 2);
//        Page<Blog> blogPage = blogService.search(name, pageable);
//        model.addAttribute("blogList", blogPage);
//        model.addAttribute("name", name);
//        return "/list";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("blogs", new Blog());
//        model.addAttribute("categories", categoryService.findAll());
//        return "/create";
//    }
//
//    @PostMapping("/save")
//    public String save(Blog blog, RedirectAttributes redirectAttributes) {
//        blogService.save(blog);
//        redirectAttributes.addFlashAttribute("message", "create success");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("blogs", blogService.findById(id));
//        model.addAttribute("categories", categoryService.findAll());
//        return "/edit";
//    }
//
//    @PostMapping("/update")
//    public String update(Blog blog, RedirectAttributes redirectAttributes) {
//        blogService.update(blog);
//        redirectAttributes.addFlashAttribute("message", "Update success");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/remove")
//    public String remeve(@RequestParam int id, RedirectAttributes redirectAttributes) {
//        blogService.remove(blogService.findById(id));
//        redirectAttributes.addFlashAttribute("message", "Delete success");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("blog", blogService.findById(id));
//        return "/view";
//    }
//}
