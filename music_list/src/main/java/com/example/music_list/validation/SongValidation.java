package com.example.music_list.validation;

import com.example.music_list.dto.Songdto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Songdto song = (Songdto) target;
        if (song.getTitle().isEmpty()) {
            errors.rejectValue("title", "title.empty", "Title is empty!");
        } else if (!song.getTitle().matches("^[a-zA-Z0-9\\s]+$")) {
            errors.rejectValue("title", "title.invalid", "Title is invalid!");
        }
        if (song.getArtist().isEmpty()) {
            errors.rejectValue("artist", "artist.empty", "Artist is empty!");
        } else if (!song.getArtist().matches("^[a-zA-Z0-9\\s]+$")) {
            errors.rejectValue("artist", "artist.invalid", "Artist is invalid!");
        }
        if (song.getType().isEmpty()) {
            errors.rejectValue("type", "type.empty", "Type is empty!");
        } else if (!song.getType().matches("^[\\p{L}0-9\\s,]+$")) {
            errors.rejectValue("type", "type.invalid", "Type is invalid!");
        }
    }
}
