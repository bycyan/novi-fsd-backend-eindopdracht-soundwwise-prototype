package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.SongDTO;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.ProjectRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository, ProjectRepository projectRepository) {
        this.songRepository = songRepository;
    }

    public SongDTO getSongById(int songId) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        return optionalSong.map(this::convertToDTO).orElse(null);
    }

    public SongDTO createSong(SongDTO songDTO) {
        Song song = convertToEntity(songDTO);
        song = songRepository.save(song);
        return convertToDTO(song);
    }

    public SongDTO updateSong(int songId, SongDTO songDTO) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        if (optionalSong.isPresent()) {
            Song existingSong = optionalSong.get();
            existingSong.setTitle(songDTO.getTitle());
            existingSong.setArtist(songDTO.getArtist());
            songRepository.save(existingSong);
            return convertToDTO(existingSong);
        }
        return null;
    }

    public boolean deleteSong(int songId) {
        if (songRepository.existsById(songId)) {
            songRepository.deleteById(songId);
            return true;
        }
        return false;
    }

    private SongDTO convertToDTO(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setSongId(song.getSongId());
        songDTO.setTitle(song.getTitle());
        songDTO.setArtist(song.getArtist());
        // Set any other properties as needed
        return songDTO;
    }

    private Song convertToEntity(SongDTO songDTO) {
        Song song = new Song();
        song.setTitle(songDTO.getTitle());
        song.setArtist(songDTO.getArtist());
        // Set any other properties as needed
        return song;
    }
}
