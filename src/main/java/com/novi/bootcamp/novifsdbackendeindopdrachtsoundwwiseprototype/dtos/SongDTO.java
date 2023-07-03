package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos;

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
