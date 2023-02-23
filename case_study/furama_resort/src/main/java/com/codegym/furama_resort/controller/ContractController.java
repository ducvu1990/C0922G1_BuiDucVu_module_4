package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.model.ContractDetail;
import com.codegym.furama_resort.service.IAttachFacilityService;
import com.codegym.furama_resort.service.IContractDetailService;
import com.codegym.furama_resort.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;
    @GetMapping("search")
    public String showList(@PageableDefault(size = 5, page = 0) Pageable pageable, Model model){
        model.addAttribute("contracts", contractService.findAll(pageable));
        model.addAttribute("attachFacilitys", attachFacilityService.findAllAttachFacility());
        model.addAttribute("contractDetail", new ContractDetail());
        return "/contract/list";
    }
    @PostMapping("/addContractDetail")
    public String saveContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes attributes){
        contractDetailService.saveContractDetail(contractDetail);
        attributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công");
        return "redirect:/contract/search";
    }
    @GetMapping("/findAllAttachFacilityByContractId")
    public String findAllAttachFacilityByContractId(@RequestParam int id, Model model){
        
    }
}
