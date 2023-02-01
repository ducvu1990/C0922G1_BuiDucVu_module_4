package com.example.app_that_displays_seasoning_with_sandwich.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {
    @GetMapping()
    public String SandwichCondiments(){
        return "condiments";
    }
    @PostMapping("/condiment")
    public String Condiments(@RequestParam("condiment") String[] condiments, Model model){
        model.addAttribute("condiments",condiments);
        return "condiments";
    }
}
