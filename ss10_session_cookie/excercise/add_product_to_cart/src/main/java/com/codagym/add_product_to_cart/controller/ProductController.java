package com.codagym.add_product_to_cart.controller;

import com.codagym.add_product_to_cart.model.Cart;
import com.codagym.add_product_to_cart.model.Product;
import com.codagym.add_product_to_cart.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam(value = "action", required = false,
    defaultValue = "") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error/404";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam(value = "action", required = false,
            defaultValue = "") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error/404";
        }
        cart.deleteProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
}