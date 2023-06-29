package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // You can add custom query methods here if needed
}
