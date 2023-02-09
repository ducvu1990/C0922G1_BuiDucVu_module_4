package com.codegym.validating_form_input.controller;

import com.codegym.validating_form_input.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping()
    public String showForm(Model model){
        model.addAttribute("users",new User());
        return "/index";
    }
    @PostMapping("/validateUser")
    public String checkValidate(@Validated @ModelAttribute("users") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        return "resulf";
    }
}
