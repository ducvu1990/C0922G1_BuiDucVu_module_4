package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @GetMapping("search")
    public String showList(@PageableDefault(size = 5, page = 0) Pageable pageable, Model model){
        model.addAttribute("contracts", contractService.findAll(pageable));
        return "/contract/list";
    }
}
