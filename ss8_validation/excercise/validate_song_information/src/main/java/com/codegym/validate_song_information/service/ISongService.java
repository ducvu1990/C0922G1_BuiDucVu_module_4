package com.codegym.validate_song_information.service;

import com.codegym.validate_song_information.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    void update(Song song);
}
