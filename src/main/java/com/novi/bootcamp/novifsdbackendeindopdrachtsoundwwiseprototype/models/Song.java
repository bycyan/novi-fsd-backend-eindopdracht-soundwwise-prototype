package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue
    private int songId;
    private String title;
    private String artist;
    private String filename;
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;

    public Song() {

    }

    public Song(int songId, String title, Project project, String filename, String filePath ) {
        this.songId = songId;
        this.title = title;
        this.artist = project.getProjectArtist();
        this.filename = filename;
        this.filePath = filePath;
        this.project = project;
    }


    // Getters and setters
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
        // Check if the project is set
        if (project != null) {
            // Set the artist of the project
            project.setProjectArtist(artist);
        }
        // Set the artist of the song
        this.artist = artist;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}

