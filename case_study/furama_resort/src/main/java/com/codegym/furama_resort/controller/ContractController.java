package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.IAttachFacilityDTO;
import com.codegym.furama_resort.model.Contract;
import com.codegym.furama_resort.model.ContractDetail;
import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.model.Facility;
import com.codegym.furama_resort.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @GetMapping("search")
    public String showList(@PageableDefault(size = 5, page = 0) Pageable pageable, Model model){
        model.addAttribute("contracts", contractService.findAll(pageable));
        model.addAttribute("attachFacilitys", attachFacilityService.findAllAttachFacility());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contract",new Contract());
        model.addAttribute("customers",customerService.findAllCustomer());
        model.addAttribute("facilitys",facilityService.findAllFacility());
        return "/contract/list";
    }
    @PostMapping("/addContractDetail")
    public String saveContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes attributes){

        if (contractDetailService.saveContractDetail(contractDetail)){
            attributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công");
            return "redirect:/contract/search";
        }
        attributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết 'không' thành công");
        return "redirect:/contract/search";
    }
}
