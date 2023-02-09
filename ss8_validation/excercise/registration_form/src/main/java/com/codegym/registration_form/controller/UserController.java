package com.codegym.registration_form.controller;

import com.codegym.registration_form.dto.UserDTO;
import com.codegym.registration_form.model.User;
import com.codegym.registration_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping()
    public String showFormCreate(Model model){
        model.addAttribute("users", new UserDTO());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("users") UserDTO userDTO, BindingResult bindingResult,
                       Model model, RedirectAttributes attributes){
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        }
        User user =new User();
        BeanUtils.copyProperties(userDTO,user);
        userService.save(user);
        model.addAttribute("users",user);
        attributes.addFlashAttribute("message", "Thêm Mới Thành Công");
        return "resulf";
    }
}
