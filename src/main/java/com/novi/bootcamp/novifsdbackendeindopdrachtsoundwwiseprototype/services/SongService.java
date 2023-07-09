package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.*;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private static SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        SongService.songRepository = songRepository;
    }
//    private final List<Song> songs = new ArrayList<>();
    public static List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public static List<Song> getSongsByProjectId(int projectId) {
        return songRepository.findByProjectProjectId(projectId);
    }

    public Song getSongById(int songId){
        return songRepository.findById(songId).orElse(null);
    }
    public Song createSong(Song song){
        Project project = song.getProject(); // Get the associated project
        if (project != null) {
            project.addSongToProject(song); // Call addSongToProject to associate the song with the project and set the artist
        }
        return songRepository.save(song);
    }

    public Song updateSong(Song song) {
        return songRepository.save(song);
    }

    public boolean deleteSong(Song song){
        try{
            songRepository.delete(song);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
