package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.ProjectDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;
    private String projectArtist;
    private String projectImage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Song> songItems;

    @ElementCollection
    private final List<String> contributors;

    public Project(){
        this.songItems = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    public Project(String projectName, String projectArtist, String projectImage, User user) {
        this.projectName = projectName;
        this.projectArtist = projectArtist;
        this.projectImage = projectImage;
        this.user = user;
        this.songItems = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    // Song Items

    public void addSongItem(Song song) {
        songItems.add(song);
    }

    public void removeSongItem(Song song) {
        songItems.remove(song);
    }

    public List<Song> getSongItems() {
        return songItems;
    }

    // Contributors

    public void addContributor(String contributor) {
        contributors.add(contributor);
    }

    public void removeContributor(String contributor) {
        contributors.remove(contributor);
    }

    public List<String> getContributors() {
        return contributors;
    }

    // Getters and Setters

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectArtist() {
        return projectArtist;
    }

    public void setProjectArtist(String projectArtist) {
        this.projectArtist = projectArtist;
    }

    public String getProjectImage() {
        return projectImage;
    }

    public void setProjectImage(String projectImage) {
        this.projectImage = projectImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSongItems(List<Song> songItems) {
        this.songItems = songItems;
    }
}
