package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.CustomerDTO;
import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.model.CustomerType;
import com.codegym.furama_resort.service.ICustomerService;
import com.codegym.furama_resort.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        if (customerService.save(customer)){
            attributes.addFlashAttribute("message", "Thêm Mới Thành Công");
            return "redirect:/furama/create";
        }
        attributes.addFlashAttribute("message", "Thêm Mới Không Thành Công");
        return "redirect:/furama/create";
    }
    @GetMapping("/search")
    private String search(@RequestParam(required = false, defaultValue = "") String name,
                          @RequestParam(required = false, defaultValue = "") String email,
                          @RequestParam(required = false, defaultValue = "") String id,
                          @RequestParam(required = false, defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page, 2);
        Page<Customer> customerPage = customerService.search(name, email, id, pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("id", id);
        model.addAttribute("customerTypes", customerTypeService.listCustomerType());
        model.addAttribute("customer", new CustomerDTO());
        return "/customer/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes attributes){
        customerService.delete(deleteId);
        attributes.addFlashAttribute("message", "Xóa Thành Công");
        return "redirect:/furama/search";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute CustomerDTO customerDTO, RedirectAttributes attributes){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.update(customer);
        attributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/furama/search";
    }
}