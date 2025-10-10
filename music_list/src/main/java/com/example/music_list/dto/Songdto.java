package com.example.music_list.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Songdto {
    @Size(min = 0, max = 800, message = "Max is 800 character")
    private String title;

    @Size(min = 0, max = 300, message = "Max is 1000 character")
    private String artist;

    @Size(min = 0, max = 1000, message = "Max is 1000 character")
    private String type;
}
