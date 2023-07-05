package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository <Song, Integer> {
}
