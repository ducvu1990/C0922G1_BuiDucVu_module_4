package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.CustomerDTO;
import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.service.ICustomerService;
import com.codegym.furama_resort.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/furama")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String home() {
        return "/layout";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute CustomerDTO customerDTO,BindingResult bindingResult,
                       RedirectAttributes attributes,
                       @RequestParam(required = false, defaultValue = "") String nameSearch,
                       @RequestParam(required = false, defaultValue = "") String email,
                       @RequestParam(required = false, defaultValue = "") String id,
                       @RequestParam(required = false, defaultValue = "0") int page, Model model
                       ) {
        new CustomerDTO().validate(customerDTO,bindingResult);
        if (bindingResult.hasErrors()){
            Pageable pageable = PageRequest.of(page, 5);
            Page<Customer> customerPage = customerService.search(nameSearch, email, id, pageable);
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("name", nameSearch);
            model.addAttribute("email", email);
            model.addAttribute("id", id);
            model.addAttribute("customerTypes", customerTypeService.listCustomerType());
            model.addAttribute("customerDTO", customerDTO);
            model.addAttribute("hasErrors", "true");
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        if (customerService.save(customer)) {
            attributes.addFlashAttribute("message", "Thêm Mới Thành Công");
            return "redirect:/furama/search";
        }
        attributes.addFlashAttribute("message", "Thêm Mới Không Thành Công");
        return "redirect:/furama/search";
    }

    @GetMapping("/search")
    private String search(@RequestParam(required = false, defaultValue = "") String nameSearch,
                          @RequestParam(required = false, defaultValue = "") String email,
                          @RequestParam(required = false, defaultValue = "") String id,
                          @RequestParam(required = false, defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Customer> customerPage = customerService.search(nameSearch, email, id, pageable);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("name", nameSearch);
        model.addAttribute("email", email);
        model.addAttribute("id", id);
        model.addAttribute("customerTypes", customerTypeService.listCustomerType());
        model.addAttribute("customerDTO", new CustomerDTO());
        return "/customer/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes attributes) {
        customerService.delete(deleteId);
        attributes.addFlashAttribute("message", "Xóa Thành Công");
        return "redirect:/furama/search";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute CustomerDTO customerDTO, RedirectAttributes attributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customerService.update(customer);
        attributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/furama/search";
    }
}
