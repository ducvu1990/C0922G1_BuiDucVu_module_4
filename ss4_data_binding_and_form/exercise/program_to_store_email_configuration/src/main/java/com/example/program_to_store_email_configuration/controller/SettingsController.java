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

import java.util.List;

@Controller

public class SettingsController {
    @Autowired
    private SettingsRepository settingsRepository;
    @GetMapping()
    public String showList(Model model){
        List<String> settings = settingsRepository.findAllEmail();
        model.addAttribute("settings", settings);
        return "home";
    }
    @GetMapping("/settings")
    public String setting(@RequestParam("setting") String setting, Model model){
        Settings settings1 = settingsRepository.findSetting(setting);
        model.addAttribute("setting", setting);
        model.addAttribute("settings1",settings1);
        return "setting";
    }
    @PostMapping("/update")
    public String updateSetting(@ModelAttribute Settings settingss,@RequestParam("email") String email, Model model){
        settingsRepository.update(settingss,email);
        List<String> settings = settingsRepository.findAllEmail();
        model.addAttribute("settings", settings);
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
