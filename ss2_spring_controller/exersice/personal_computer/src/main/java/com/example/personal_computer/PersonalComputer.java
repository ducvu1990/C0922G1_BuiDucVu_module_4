package com.example.personal_computer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonalComputer {
    @GetMapping()
    public String personalComputer() {
        return "computer";
    }

    @PostMapping("/calculate")
    public String Computer(@RequestParam int numberOne, int numberTwo, String calculation, Model model) {
        int result = 0;
        switch (calculation){
            case "+":
                result = numberOne + numberTwo;
                model.addAttribute("result",result);
                break;
            case "-":
                result = numberOne - numberTwo;
                model.addAttribute("result",result);
                break;
            case "*":
                result = numberOne * numberTwo;
                model.addAttribute("result",result);
                break;
            case "/":
                if (numberTwo != 0){
                    result = numberOne / numberTwo;
                    model.addAttribute("result",result);
                }else {

                    model.addAttribute("result","cannot be divided by 0");
                }
                break;
        }
        return "computer";
    }
}
