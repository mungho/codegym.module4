package com.example.music_list.service;

import com.example.music_list.dto.Songdto;
import com.example.music_list.entity.Song;
import com.example.music_list.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository songRepository;

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(int id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addSong(Song song) {
        return songRepository.save(song) != null;
    }
}
