package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.SongDTO;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

//    @GetMapping
//    public ResponseEntity<List<Song>> getAllSongs() {
//        List<Song> songs = songService.getAllSongs();
//        return ResponseEntity.ok(songs);
//    }

    @GetMapping()
    public ResponseEntity<List<SongDTO>> getAllSongs() {
        List<Song> songs = SongService.getAllSongs();
        List<SongDTO> songDTOs = new ArrayList<>();

        HttpHeaders responseHeaders = null;
        for (Song song : songs) {
            SongDTO songDTO = new SongDTO();
            songDTO.setSongId(song.getSongId());
            songDTO.setTitle(song.getTitle());
            songDTO.setArtist(song.getArtist());
            songDTO.setFilename(song.getFilename());
            songDTO.setFilePath(song.getFilePath());

            // Set the project ID in the response headers
            responseHeaders = new HttpHeaders();
            responseHeaders.add("project-id", String.valueOf(song.getProject().getProjectId()));

            songDTOs.add(songDTO);
        }

        return ResponseEntity.ok().headers(responseHeaders).body(songDTOs);
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

