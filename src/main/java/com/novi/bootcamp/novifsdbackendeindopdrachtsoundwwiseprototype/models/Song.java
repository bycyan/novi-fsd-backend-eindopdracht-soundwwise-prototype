package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue
    private int songId;
    private String title;
    private String artist;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;

    public Song(int songId, String title, String artist, Project project) {
        this.songId = songId;
        this.title = title;
        this.artist = project.getProjectArtist();
        this.project = project;
    }

    public Song() {

    }

    // Getters and setters for songId, title, and artist

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

