package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;

public class SongDTO {
    private int songId;
    private String title;
    private String artist;
    private String filename;
    private String filePath;
    private ProjectDTO project;

    // Constructors

    public SongDTO() {
    }

    public SongDTO(String title, String artist, String filename, String filePath, Project project) {
        this.title = title;
        this.artist = project.getProjectArtist();
        this.filename = filename;
        this.filePath = filePath;
        this.project = ProjectDTO.convertToDTO(project);
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

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }
}
