package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;

import java.util.Optional;

public class SongDTO {
    private int songId;
    private String title;
    private String artist;

    // Constructors

    public SongDTO() {
    }

    public SongDTO(int songId, String title, String artist) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
    }

    public static SongDTO convertToDTO(Song song) {
        SongDTO dto = new SongDTO();
        dto.setTitle(song.getTitle());
        // Add any other properties of the SongDTO class that you want to set

        return dto;
    }

    // Getters and Setters

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}
