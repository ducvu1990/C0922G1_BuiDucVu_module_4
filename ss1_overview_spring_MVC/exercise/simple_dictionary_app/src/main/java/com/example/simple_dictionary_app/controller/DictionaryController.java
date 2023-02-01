package com.example.simple_dictionary_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    static Map<String,String> map = new HashMap<>();
    static {
        map.put("red","Màu Đỏ");
        map.put("yellow","Màu Vàng");
        map.put("green","Màu Xanh");
    }
    @GetMapping()
    public String dictionary(){
        return "dictionary";
    }
    @PostMapping("/translate")
    public String Translate(@RequestParam String english, Model model){
        if (map.get(english) != null) {
            model.addAttribute("map", map.get(english));
        }else {
            model.addAttribute("map","không tìm thấy");
        }
        return "dictionary";
    }
}
