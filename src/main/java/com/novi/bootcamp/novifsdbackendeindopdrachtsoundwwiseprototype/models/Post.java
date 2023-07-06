package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String postType;

    private int likes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonManagedReference
    private List<Comment> comments;

    public Post() {
        comments = new ArrayList<>();
    }

    // Getters and Setters

    public Long getId() {
        return postId;
    }

    public void setId(Long id) {
        this.postId = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void like() {
        this.likes++;
    }

    public void addComment(String content, User user) {
        Comment comment = new Comment(content, user, this); // Pass 'this' as the 'Post' object
        comments.add(comment);
        comment.setPost(this); // Establishing bidirectional relationship
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null); // Clearing bidirectional relationship
    }

    public List<Comment> getComments() {
        return comments;
    }
}
