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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public Project(int projectId, String projectName, String projectArtist, String projectImage, User user) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectArtist = projectArtist;
        this.projectImage = projectImage;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSongItems(List<Song> songItems) {
        this.songItems = songItems;
    }

    public void setContentItems(List<ContentItem> contentItems) {
        this.contentItems = contentItems;
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

    // Convert Project to ProjectDTO
    public ProjectDTO convertToDTO() {
        ProjectDTO dto = new ProjectDTO();
        dto.setProjectId(this.getProjectId());
        dto.setProjectName(this.getProjectName());
        dto.setProjectArtist(this.getProjectArtist());
        dto.setProjectImage(this.getProjectImage());
        dto.setUserId(this.getUser().getId()); // Set the user ID

        return dto;
    }
}
