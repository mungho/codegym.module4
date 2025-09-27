package com.example.lesson1_2_dictionary.controller;

import com.example.lesson1_2_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String showDictionary(){
        return "dictionary";
    }

    @GetMapping("/dictionary/search")
    public String searchWord(@RequestParam("word") String word, Model model){
        model.addAttribute("word", dictionaryService.searchWord(word));
        return "dictionary";
    }
}
