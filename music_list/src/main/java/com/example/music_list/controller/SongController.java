package com.example.music_list.controller;

import com.example.music_list.dto.Songdto;
import com.example.music_list.entity.Song;
import com.example.music_list.service.ISongService;
import com.example.music_list.validation.SongValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("")
    public String getAllSongs(Model model){
        model.addAttribute("songList", songService.getAllSongs());
        model.addAttribute("song", new Songdto());
        return "song/list";
    }

    @GetMapping("/addSong")
    public String showForm (Model model) {
        model.addAttribute("song", new Songdto());
        model.addAttribute("songList", songService.getAllSongs());
        model.addAttribute("openAddModal", "true");
        return "song/list";
    }

    @PostMapping("/addSong")
    public String addSong(@Validated @ModelAttribute(name = "song") Songdto song,
                          BindingResult bindingResult,
                          Model model, RedirectAttributes redirectAttributes) {
        SongValidation songValidation = new SongValidation();
        songValidation.validate(song, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("songList", songService.getAllSongs());
            model.addAttribute("openAddModal", "true");
            return "song/list";
        }
        Song newSong = new Song();
        BeanUtils.copyProperties(song, newSong);
        songService.addSong(newSong);
        redirectAttributes.addFlashAttribute("mess", "Add song successfully!");
        return "redirect:/";
    }
}
