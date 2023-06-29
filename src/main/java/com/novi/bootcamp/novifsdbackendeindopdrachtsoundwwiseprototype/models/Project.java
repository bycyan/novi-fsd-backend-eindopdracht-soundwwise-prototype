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

    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Song> songItems;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContentItem> contentItems;

    @ElementCollection
    private final List<String> contributors;

    public Project(){
        this.songItems = new ArrayList<>();
        this.contentItems = new ArrayList<>();
        this.contributors = new ArrayList<>();
    }

    public Project(int projectId, String projectName, String projectArtist, String projectImage) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectArtist = projectArtist;
        this.projectImage = projectImage;
        this.songItems = new ArrayList<>();
        this.contentItems = new ArrayList<>();
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

    // Content Items

    public void addContentItem(ContentItem contentItem) {
        contentItems.add(contentItem);
    }

    public void removeContentItem(ContentItem contentItem) {
        contentItems.remove(contentItem);
    }

    public List<ContentItem> getContentItems() {
        return contentItems;
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

    // Inner class: ContentItem
    @Entity
    @Table(name = "content_items")
    public static class ContentItem {
        @Id
        private int contentItemId;
        private String contentItemName;

        public ContentItem(int contentItemId, String contentItemName) {
            this.contentItemId = contentItemId;
            this.contentItemName = contentItemName;
        }

        public ContentItem() {

        }

        // ContentItem getters and setters

        public int getContentItemId() {
            return contentItemId;
        }

        public void setContentItemId(int contentItemId) {
            this.contentItemId = contentItemId;
        }

        public String getContentItemName() {
            return contentItemName;
        }

        public void setContentItemName(String contentItemName) {
            this.contentItemName = contentItemName;
        }
    }
}
