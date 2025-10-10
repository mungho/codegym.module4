package com.example.music_list.service;

import com.example.music_list.dto.Songdto;
import com.example.music_list.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAllSongs();
    Song getSongById(int id);
    boolean addSong(Song song);
}
