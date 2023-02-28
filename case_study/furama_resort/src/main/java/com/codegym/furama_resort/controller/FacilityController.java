package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.FacilityDTO;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFaciityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/search")
    private String search(@RequestParam(required = false, defaultValue = "") String nameSearch,
                          @RequestParam(required = false, defaultValue = "") String id,
                          @RequestParam(required = false, defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Facility> facilityPage = facilityService.search(nameSearch, id, pageable);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("name", nameSearch);
        model.addAttribute("id", id);
        model.addAttribute("facilityTypes", facilityTypeService.listFacilityType());
        model.addAttribute("rentTypes", rentTypeService.listRentType());
        model.addAttribute("facilityDTO", new FacilityDTO());
        return "/facility/list";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute FacilityDTO facilityDTO, BindingResult bindingResult,
                       @RequestParam(required = false, defaultValue = "") String nameSearch,
                       @RequestParam(required = false, defaultValue = "") String id,
                       @RequestParam(required = false, defaultValue = "0") int page, Model model,
                       RedirectAttributes attributes){
        if (bindingResult.hasErrors()){
            Pageable pageable = PageRequest.of(page, 5);
            Page<Facility> facilityPage = facilityService.search(nameSearch, id, pageable);
            model.addAttribute("facilityPage", facilityPage);
            model.addAttribute("name", nameSearch);
            model.addAttribute("id", id);
            model.addAttribute("facilityTypes", facilityTypeService.listFacilityType());
            model.addAttribute("rentTypes", rentTypeService.listRentType());
            model.addAttribute("facilityDTO", facilityDTO);
            model.addAttribute("hasErrors", "true");
            return "/facility/list";
        }
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
