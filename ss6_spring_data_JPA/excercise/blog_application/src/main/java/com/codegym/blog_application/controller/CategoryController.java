package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list-category")
    public String listCategory(Model model){
        model.addAttribute("category", categoryService.findAll());
        return "list-category";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category", new Category());
        return "create-category";
    }
    @PostMapping("/save")
    public String save(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "create success");
        return "redirect:/category/list-category";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "edit-category";
    }
    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message","Update success");
        return "redirect:/category/list-category";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "delete-category";
    }
    @PostMapping("/remove")
    public String remove(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.remove(category);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/category/list-category";
    }
}
