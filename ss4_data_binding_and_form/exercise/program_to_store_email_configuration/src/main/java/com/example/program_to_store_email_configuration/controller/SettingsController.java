package com.example.program_to_store_email_configuration.controller;

import com.example.program_to_store_email_configuration.model.Settings;
import com.example.program_to_store_email_configuration.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller

public class SettingsController {
    String email;
    @Autowired
    SettingsRepository settingsRepository;
    @GetMapping()
    public String showList(Model model){
        List<String> settings = settingsRepository.finAllEmail();
        model.addAttribute("settings", settings);
        return "home";
    }
    @GetMapping("/settings")
    public String setting(@RequestParam("setting") String setting, Model model){
        email = setting;
        Settings settings1 = settingsRepository.finSetting(setting);
        model.addAttribute("settings1",settings1);
        return "setting";
    }
    @GetMapping("/update")
    public String updateSetting(@ModelAttribute Settings settingss,Model model){
        settingsRepository.update(settingss,email);
        List<String> settings = settingsRepository.finAllEmail();
        model.addAttribute("settings", settings);
        email = "";
        return "home";
    }
    @ModelAttribute("language")
    public String[] arrayLanguage(){
        return new String[]{ "English", "Vietnamese", "Japanese", "Chinese"};
    }
    @ModelAttribute("pageSize")
    public Integer[] arraypageSize(){
        return new Integer[]{5,10,15,25,50,100};
    }
}
