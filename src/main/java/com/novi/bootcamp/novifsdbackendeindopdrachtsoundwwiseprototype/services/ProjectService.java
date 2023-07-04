package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int projectId) {
        return projectRepository.findById(projectId);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }
//
//    public boolean deleteProject(int projectId) {
//        return projectRepository.deleteProject(projectId);
//    }
//
//    public List<Song> getAllSongs() {
//        return projectRepository.getAllSongs();
//    }
//
//    public Song getSongById(int songId) {
//        return projectRepository.getSongById(songId);
//    }
//
//    public Song createSong(Song song) {
//        return projectRepository.createSong(song);
//    }
//
//    public Song updateSong(int songId, Song song) {
//        return projectRepository.updateSong(songId, song);
//    }
//
//    public boolean deleteSong(int songId) {
//        return projectRepository.deleteSong(songId);
//    }
//
//    public List<Song> getAllSongsForProject(int projectId) {
//        return projectRepository.getAllSongsForProject(projectId);
//    }
//
//    public Song getSongForProjectById(int projectId, int songId) {
//        return projectRepository.getSongForProjectById(projectId, songId);
//    }
//
//    public Song addSongToProject(int projectId, Song song) {
//        return projectRepository.addSongToProject(projectId, song);
//    }
//
//    public boolean removeSongFromProject(int projectId, int songId) {
//        return projectRepository.removeSongFromProject(projectId, songId);
//    }
//
//    public List<File> getAllFilesForProject(int projectId) {
//        return projectRepository.getAllFilesForProject(projectId);
//    }
//
//    public File addFileToProject(int projectId, File file) {
//        return projectRepository.addFileToProject(projectId, file);
//    }
//
//    public boolean removeFileFromProject(int projectId, int fileId) {
//        return projectRepository.removeFileFromProject(projectId, fileId);
//    }
//
//    public List<File> getAllFiles() {
//        return projectRepository.getAllFiles();
//    }
//
//    public File getFileById(int fileId) {
//        return projectRepository.getFileById(fileId);
//    }
//
//    public File createFile(File file) {
//        return projectRepository.createFile(file);
//    }
//
//    public File updateFile(int fileId, File file) {
//        return projectRepository.updateFile(fileId, file);
//    }
//
//    public boolean deleteFile(int fileId) {
//        return projectRepository.deleteFile(fileId);
//    }
}
