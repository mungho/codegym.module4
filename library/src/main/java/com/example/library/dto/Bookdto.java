package com.example.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bookdto {
    private String code;
    private String title;
    private String author;
    private int year;
    private int amount;
}
