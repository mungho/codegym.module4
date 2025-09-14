package com.example.lesson1_2_dictionary.service;

import com.example.lesson1_2_dictionary.repository.IDictionaryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    IDictionaryController dictionaryController;

    @Override
    public String searchWord(String word) {
        return dictionaryController.searchWord(word);
    }
}
