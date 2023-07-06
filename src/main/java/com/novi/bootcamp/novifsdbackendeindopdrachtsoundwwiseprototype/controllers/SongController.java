package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/{songId}")
    public ResponseEntity<Song> getSongById(@PathVariable int songId){
        Song song = songService.getSongById(songId);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        Song createdSong = songService.createSong(song);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSong);
    }

    @PutMapping("/{songId}")
    public ResponseEntity<Song> updateSong(@PathVariable int songId, @RequestBody Song updatedSong){
        Song song = songService.getSongById(songId);
        if (song != null){
            song.setTitle(updatedSong.getTitle());
            song.setArtist(updatedSong.getArtist());
            song.setFilename(updatedSong.getFilename());
            song.setFilePath(updatedSong.getFilePath());
            songService.updateSong(song);
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{songId}")
    public ResponseEntity<Void> deleteSong(@PathVariable int songId) {
        Song song = songService.getSongById(songId);
        if (song != null) {
            songService.deleteSong(song);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

