package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.CustomerDTO;
import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.model.CustomerType;
import com.codegym.furama_resort.service.ICustomerService;
import com.codegym.furama_resort.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/furama")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;
    @GetMapping("/create")
    public String showFormCreateCustomer(Model model){
        model.addAttribute("customer", new CustomerDTO());
        model.addAttribute("customerTypes", customerTypeService.listCustomerType());
        return "/customer/createCustomer";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute CustomerDTO customerDTO, RedirectAttributes attributes){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.save(customer);
        attributes.addFlashAttribute("message", "Thêm Mới Thành Công");
        return "redirect:/furama/create";
    }
}
