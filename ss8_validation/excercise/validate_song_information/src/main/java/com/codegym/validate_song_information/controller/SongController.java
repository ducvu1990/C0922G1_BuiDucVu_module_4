package com.codegym.validate_song_information.controller;

import com.codegym.validate_song_information.dto.SongDTO;
import com.codegym.validate_song_information.model.Song;
import com.codegym.validate_song_information.service.ISongService;
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
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listSong(@RequestParam(required = false,defaultValue = "") String name, Model model,
                           @RequestParam(required = false,defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,2);
        Page<Song> songPage =songService.search(name, pageable);
        model.addAttribute("songPage", songPage);
        model.addAttribute("name",name);
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("song", new SongDTO());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("song") SongDTO songDTO, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "create success");
        return "redirect:/song";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("song") SongDTO songDTO, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "update success");
        return "redirect:/song";
    }
}
