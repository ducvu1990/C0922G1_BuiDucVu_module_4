package com.codegym.custom_validation.controller;

import com.codegym.custom_validation.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/number")
public class PhonreController {
    @GetMapping()
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "/index";
    }
    @PostMapping("/e")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber,
                                   BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "/resulf";
        }
    }
}
