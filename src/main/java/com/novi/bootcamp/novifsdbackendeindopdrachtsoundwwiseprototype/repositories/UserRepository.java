package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Add custom query methods if needed
}

