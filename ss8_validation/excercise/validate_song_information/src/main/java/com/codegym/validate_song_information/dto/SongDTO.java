package com.codegym.validate_song_information.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

public class SongDTO implements Validator {
    private int id;

    @Size(max = 800,message = "không quá 800 ký tự")
    @NotBlank(message = "Tên không được để ký tự trống")
    private String name;

    @Size(max = 300, message = "không quá 300 ký tự")
    @NotBlank(message = "Tác Giả không được để ký tự trống")
    private String artist;

    @Size(max = 1000,message = "không quá 1000 ký tự")
    @NotBlank(message = "Thể loại không được để ký tự trống")
    private String kindOfMusic;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;

        ValidationUtils.rejectIfEmpty(errors,"name","name"," Tên không được để trống");
        ValidationUtils.rejectIfEmpty(errors,"artist","artist","Tác Giả không được để trống");
        ValidationUtils.rejectIfEmpty(errors,"kindOfMusic","kindOfMusic","Thể Loại không được để trống");

        String name = songDTO.getName();
        String artist = songDTO.getArtist();
        String kindOfMusic = songDTO.getKindOfMusic();
        if (!name.matches("^[a-zA-Z0-9\\s]+$")){
            errors.rejectValue("name","name","không đúng định dạng");
        }
        if (!artist.matches("^[a-zA-Z0-9\\s]+$")){
            errors.rejectValue("artist", "artist", "không đúng định dạng");
        }
        if (!kindOfMusic.matches("^[a-zA-Z0-9,\\s]+$")){
            errors.rejectValue("kindOfMusic", "kindOfMusic", "không đúng định dạng");
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
