package com.codegym.validate_song_information.service;

import com.codegym.validate_song_information.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
Page<Song> search(String name, Pageable pageable);
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void update(Song song);
}
