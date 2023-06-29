package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

