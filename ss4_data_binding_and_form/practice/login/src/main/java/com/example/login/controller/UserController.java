package com.example.login.controller;

import com.example.login.model.Login;
import com.example.login.model.User;
import com.example.login.ripository.UserRipository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping()
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("home","login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserRipository.checkLogin(login);
        if (user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("user","user", user);
            return modelAndView;
        }
    }
}
