package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos;

public class UserDTO {
    private int userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String jobDescription;
    private String profileImg;
    private String profileHeader;

    // Constructors

    public UserDTO() {
    }

    public UserDTO(int userId, String email, String password, String firstName, String lastName, String jobDescription, String profileImg, String profileHeader) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobDescription = jobDescription;
        this.profileImg = profileImg;
        this.profileHeader = profileHeader;
    }

    // Getters and Setters

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
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}

