package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int userId;
    private String email;
    private String password;
    private String firstName;
    private String LastName;
    private String jobDescription;
    private String profileImg;
    private String profileHeader;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> showcaseProjects;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;


    public User() {
    }

    public User(int userId, String email, String password, String firstName, String lastName, String jobDescription, String profileImg, String profileHeader, List<Project> showcaseProjects, List<Task> tasks, List<Post> posts) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        LastName = lastName;
        this.jobDescription = jobDescription;
        this.profileImg = profileImg;
        this.profileHeader = profileHeader;
        this.showcaseProjects = showcaseProjects;
        this.tasks = tasks;
        this.posts = posts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getProfileHeader() {
        return profileHeader;
    }

    public void setProfileHeader(String profileHeader) {
        this.profileHeader = profileHeader;
    }

    public List<Project> getShowcaseProjects() {
        return showcaseProjects;
    }

    public void setShowcaseProjects(List<Project> showcaseProjects) {
        this.showcaseProjects = showcaseProjects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    //Just for the git test
}
