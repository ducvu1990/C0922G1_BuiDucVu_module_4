package com.codegym.validate_song_information.controller;

import com.codegym.validate_song_information.dto.SongDTO;
import com.codegym.validate_song_information.model.Song;
import com.codegym.validate_song_information.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping()
    public String listSong(Model model) {
        model.addAttribute("songs", songService.findAll());
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
}
