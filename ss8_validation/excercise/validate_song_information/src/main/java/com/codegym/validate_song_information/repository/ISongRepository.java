package com.codegym.validate_song_information.repository;

import com.codegym.validate_song_information.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
    Page<Song> findSongByNameContains(String name, Pageable pageable);
}
