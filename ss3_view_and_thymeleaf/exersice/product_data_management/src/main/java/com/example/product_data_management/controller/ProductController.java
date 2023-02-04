package com.example.product_data_management.controller;

import com.example.product_data_management.model.Product;
import com.example.product_data_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping()
    public String ListProduct(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 1000));
        Product product1 = productService.findById(product.getId());
        if (product1 == null) {
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "create success");
            return "redirect:/product";
        } else {
            redirectAttributes.addFlashAttribute("message", "create failure");
            return "redirect:/product";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product,RedirectAttributes redirectAttributes){
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message","update success");
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String remave(Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message","delete success");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model, RedirectAttributes  redirectAttributes){
        List<Product> products = productService.search(name);
        if (products.size() != 0){
            model.addAttribute("products", products);
            return "/search";
        }else {
            redirectAttributes.addFlashAttribute("message","No Data");
            return "redirect:/product";
        }
    }
}
