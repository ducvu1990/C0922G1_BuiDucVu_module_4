package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public String ListBlog(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogs", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "create success");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogs", blogService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes){
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message","Update success");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blogs", blogService.findById(id));
        return "/remove";
    }
    @PostMapping("/remove")
    public String remeve(Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/blog";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }
}
