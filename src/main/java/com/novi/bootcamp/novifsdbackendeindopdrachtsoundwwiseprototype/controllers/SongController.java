package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.SongDTO;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.SongService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public ResponseEntity<List<SongDTO>> getAllSongs(@RequestParam("projectId") int projectId) {
        List<Song> songs = SongService.getAllSongs(projectId);
        List<SongDTO> songDTOs = new ArrayList<>();

        for (Song song : songs) {
            SongDTO songDTO = new SongDTO();
            songDTO.setSongId(song.getSongId());
            songDTO.setTitle(song.getTitle());
            songDTO.setArtist(song.getArtist());
            songDTO.setFilename(song.getFilename());
            songDTO.setFilePath(song.getFilePath());
            songDTO.setProjectId(song.getProject().getProjectId()); // Include the projectId

            songDTOs.add(songDTO);
        }

        return ResponseEntity.ok().body(songDTOs);
    }


//    @GetMapping()
//    public ResponseEntity<List<SongDTO>> getAllSongs() {
//        List<Song> songs = SongService.getAllSongs();
//        List<SongDTO> songDTOs = new ArrayList<>();
//
//        HttpHeaders responseHeaders = null;
//        for (Song song : songs) {
//            SongDTO songDTO = new SongDTO();
//            songDTO.setSongId(song.getSongId());
//            songDTO.setTitle(song.getTitle());
//            songDTO.setArtist(song.getArtist());
//            songDTO.setFilename(song.getFilename());
//            songDTO.setFilePath(song.getFilePath());
//
//            // Set the project ID in the response headers
//            responseHeaders = new HttpHeaders();
//            responseHeaders.add("project-id", String.valueOf(song.getProject().getProjectId()));
//
//            songDTOs.add(songDTO);
//        }
//
//        return ResponseEntity.ok().headers(responseHeaders).body(songDTOs);
//    }


    @GetMapping("/{songId}")
    public ResponseEntity<Song> getSongById(@PathVariable int songId){
        Song song = songService.getSongById(songId);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping
//    public ResponseEntity<Song> createSong(@RequestBody Song song) {
//        Song createdSong = songService.createSong(song);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdSong);
//    }

//    @PostMapping
//    public ResponseEntity<SongDTO> createSong(@RequestBody Song song) {
//        // Create the song using the provided data
//
//        // Save the song to the database and retrieve the updated song object
//        Song createdSong = songService.createSong(song);
//
//        // Convert the createdSong to a SongDTO or include only the required fields
//        SongDTO createdSongDTO = new SongDTO();
//        createdSongDTO.setSongId(createdSong.getSongId());
//        createdSongDTO.setTitle(createdSong.getTitle());
//        createdSongDTO.setArtist(createdSong.getArtist());
//        // Include other required fields
//
//        return ResponseEntity.ok(createdSongDTO);
//    }
@PostMapping
public ResponseEntity<SongDTO> createSong(@RequestParam("file") MultipartFile file,
                                          @RequestParam("title") String title) {
    try {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String uploadDir = "./uploads/"; // Specify the directory where uploaded files will be stored
        String filePath = uploadDir + fileName;
        File dest = new File(filePath);
        FileUtils.forceMkdirParent(dest);
        file.transferTo(dest);

        Song song = new Song();
        song.setTitle(title);
        song.setFilePath(filePath);

        Song createdSong = songService.createSong(song);

        // Convert the createdSong to a SongDTO or include only the required fields
        SongDTO createdSongDTO = new SongDTO();
        createdSongDTO.setSongId(createdSong.getSongId());
        createdSongDTO.setTitle(createdSong.getTitle());
        createdSongDTO.setArtist(createdSong.getArtist());
        // Include other required fields

        return ResponseEntity.ok(createdSongDTO);
    } catch (IOException e) {
        // Handle file upload error
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
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

