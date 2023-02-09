package com.codegym.validate_song_information.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class SongDTO implements Validator {
    private int id;
    @NotEmpty
    @Max(800)
    private String name;
    @NotEmpty
    @Max(300)
    private String artist;
    @NotEmpty
    @Max(1000)
    private String kindOfMusic;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        String name = songDTO.getName();
        String artist = songDTO.getArtist();
        String kindOfMusic = songDTO.getKindOfMusic();
        if (!name.matches("^[a-zA-Z0-9]+$")){
            errors.rejectValue("name","name1","Malformed");
        }
        if (!artist.matches("^[a-zA-Z0-9]+$")){
            errors.rejectValue("artist", "artist1", "Malformed");
        }
        if (!kindOfMusic.matches("^[a-zA-Z0-9,]+$")){
            errors.rejectValue("kindOfMusic", "kindOfMusic1", "Malformed");
        }
    }

    public SongDTO() {
    }

    public SongDTO(int id, String name, String artist, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }


}
