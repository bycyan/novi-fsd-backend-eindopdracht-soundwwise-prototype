package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models;

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

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "project")
    private List<Song> songItems;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "project")
    private List<File> fileItems;

    @ElementCollection
    private final List<String> contributors;

    public Project() {
        this.fileItems = new ArrayList<>();
        this.songItems = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    public Project(String projectName, String projectArtist, String projectImage, User user, List<File> fileItems) {
        this.projectName = projectName;
        this.projectArtist = projectArtist;
        this.projectImage = projectImage;
        this.user = user;
        this.fileItems = new ArrayList<>();
        this.songItems = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    // Song Items
    public void addSongItem(Song song) {
        songItems.add(song);
        song.setProject(this);
        song.setArtist(this.projectArtist);
    }

//    public void addSongToProject(Song song) {
//        songItems.add(song);
//        song.setProject(this); // Set the project for the song
//        song.setArtist(this.projectArtist); // Set the artist for the song
//    }

    public void removeSongItem(Song song) {
        songItems.remove(song);
        song.setProject(null);
    }

    public List<Song> getSongItems() {
        return songItems;
    }


    // File Items
    public void addFileItem(File file) {
        fileItems.add(file);
        file.setProject(this); // Set the project for the file
    }

    public void removeFileItem(File file) {
        fileItems.remove(file);
        file.setProject(null); // Remove the project reference from the file
    }

    public List<File> getFileItems() {
        return fileItems;
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


    ////

//    public void setSongItems(List<Song> songItems) {
//        this.songItems = songItems;
//        setProjectIdForSongs();
//        updateSongArtists();
//    }
//
//    private void setProjectIdForSongs() {
//        if (songItems != null) {
//            for (Song song : songItems) {
//                song.setProject(this);
//            }
//        }
//    }
//
//    private void updateSongArtists() {
//        if (songItems != null) {
//            for (Song song : songItems) {
//                song.setArtist(this.projectArtist);
//            }
//        }
//    }

}
