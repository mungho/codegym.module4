package com.example.lesson1_2_dictionary.repository;

import com.example.lesson1_2_dictionary.entiry.EnVi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository implements IDictionaryController{
    static List<EnVi> listEnVi = new ArrayList<>();
    static {
        listEnVi.add(new EnVi("hello", "xin chào"));
        listEnVi.add(new EnVi("table", "cái bàn"));
        listEnVi.add(new EnVi("chair", "cái ghế"));
    }

    @Override
    public String searchWord(String word) {
        for (EnVi enVi : listEnVi) {
            if (enVi.getEnglish().equals(word)) {
                return enVi.getVietnam();
            }
        }
        return "Not found";
    }
}
