package com.example.currency_converter_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverter {
    @GetMapping
    public String currencyConverter(){
        return "vnd";
    }
    @PostMapping("/currency-converter")
    public String currency(@RequestParam Double usd, Double rate, Model model){
        double vnd = usd * rate;
        model.addAttribute("vnd",vnd);
        return "vnd";
    }
}
