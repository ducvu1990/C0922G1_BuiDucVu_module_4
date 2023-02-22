package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.CustomerDTO;
import com.codegym.furama_resort.dto.FacilityDTO;
import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.model.Facility;
import com.codegym.furama_resort.service.IFaciityTypeService;
import com.codegym.furama_resort.service.IFacilityService;
import com.codegym.furama_resort.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFaciityTypeService faciityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/search")
    private String search(@RequestParam(required = false, defaultValue = "") String name,
                          @RequestParam(required = false, defaultValue = "") String facilityType,
                          @RequestParam(required = false, defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Facility> facilityPage = facilityService.search(name, facilityType, pageable);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("name", name);
        model.addAttribute("id", facilityType);
        model.addAttribute("facilityTypes", faciityTypeService.listFacilityType());
        model.addAttribute("rentTypes", rentTypeService.listRentType());
        model.addAttribute("facility", new FacilityDTO());
        return "/facility/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute FacilityDTO facilityDTO, RedirectAttributes attributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO,facility);
        if (facilityService.save(facility)){
            attributes.addFlashAttribute("message", "Thêm Mới Thành Công");
            return "redirect:/facility/search";
        }
        attributes.addFlashAttribute("message", "Thêm Mới Không Thành Công");
        return "redirect:/facility/search";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes attributes){
        facilityService.delete(deleteId);
        attributes.addFlashAttribute("message", "Xóa Thành Công");
        return "redirect:/facility/search";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute FacilityDTO facilityDTO, RedirectAttributes attributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO,facility);
        facilityService.update(facility);
        attributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/facility/search";
    }
}