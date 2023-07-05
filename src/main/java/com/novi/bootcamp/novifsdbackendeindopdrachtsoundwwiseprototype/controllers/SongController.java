package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.SongDTO;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/songs")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/{songId}")
    public ResponseEntity<SongDTO> getSongById(@PathVariable int songId) {
        SongDTO songDTO = songService.getSongById(songId);
        if (songDTO != null) {
            return ResponseEntity.ok(songDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SongDTO> createSong(@RequestBody SongDTO songDTO) {
        SongDTO createdSongDTO = songService.createSong(songDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSongDTO);
    }

    @PutMapping("/{songId}")
    public ResponseEntity<SongDTO> updateSong(@PathVariable int songId, @RequestBody SongDTO songDTO) {
        SongDTO updatedSongDTO = songService.updateSong(songId, songDTO);
        if (updatedSongDTO != null) {
            return ResponseEntity.ok(updatedSongDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{songId}")
    public ResponseEntity<Void> deleteSong(@PathVariable int songId) {
        boolean deleted = songService.deleteSong(songId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

