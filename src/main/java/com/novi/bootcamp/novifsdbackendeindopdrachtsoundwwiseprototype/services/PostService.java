package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.PostDTO;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Comment;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Post;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.CommentRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public PostDTO.CommentDTO createComment(Long postId, PostDTO.CommentDTO commentDTO) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            Comment comment = new Comment();
            comment.setContent(commentDTO.getContent());

            User user = new User();
            user.setUserId(commentDTO.getUser().getUserId());
            // Set other user properties if needed

            comment.setUser(user);
            comment.setPost(post);

            post.getComments().add(comment);
            postRepository.save(post);

            return commentDTO;
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }

    public List<Comment> getCommentsForPost(Long postId) {
        // Retrieve the post
        Post post = postRepository.findById(postId).orElse(null);
        if (post == null) {
            // Post not found
            throw new IllegalArgumentException("Post not found");
        }

        // Retrieve comments for the post
        return post.getComments();
    }
}
