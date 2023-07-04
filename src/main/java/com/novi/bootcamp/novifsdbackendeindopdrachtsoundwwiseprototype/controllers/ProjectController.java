package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Optional<Project>> getProjectById(@PathVariable int projectId) {
        Optional<Project> project = projectService.getProjectById(projectId);
        if (project.isPresent()) {
            return ResponseEntity.ok(project);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        Project updatedProject = projectService.updateProject(project);
        if (updatedProject != null) {
            return ResponseEntity.ok(updatedProject);
        }
        return ResponseEntity.notFound().build();
    }
//
//    @DeleteMapping("/{projectId}")
//    public ResponseEntity<Void> deleteProject(@PathVariable int projectId) {
//        boolean deleted = projectService.deleteProject(projectId);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/{projectId}/tasks")
//    public ResponseEntity<List<Task>> getAllTasksForProject(@PathVariable int projectId) {
//        List<Task> tasks = projectService.getAllTasksForProject(projectId);
//        return ResponseEntity.ok(tasks);
//    }
//
//    @PostMapping("/{projectId}/tasks")
//    public ResponseEntity<Task> addTaskToProject(@PathVariable int projectId, @RequestBody Task task) {
//        Task addedTask = projectService.addTaskToProject(projectId, task);
//        if (addedTask != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(addedTask);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/{projectId}/tasks/{taskId}")
//    public ResponseEntity<Task> updateTask(@PathVariable int projectId, @PathVariable int taskId, @RequestBody Task task) {
//        Task updatedTask = projectService.updateTask(projectId, taskId, task);
//        if (updatedTask != null) {
//            return ResponseEntity.ok(updatedTask);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{projectId}/tasks/{taskId}")
//    public ResponseEntity<Void> removeTaskFromProject(@PathVariable int projectId, @PathVariable int taskId) {
//        boolean removed = projectService.removeTaskFromProject(projectId, taskId);
//        if (removed) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/songs")
//    public ResponseEntity<List<Song>> getAllSongs() {
//        List<Song> songs = projectService.getAllSongs();
//        return ResponseEntity.ok(songs);
//    }
//
//    @GetMapping("/songs/{songId}")
//    public ResponseEntity<Song> getSongById(@PathVariable int songId) {
//        Song song = projectService.getSongById(songId);
//        if (song != null) {
//            return ResponseEntity.ok(song);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/songs")
//    public ResponseEntity<Song> createSong(@RequestBody Song song) {
//        Song createdSong = projectService.createSong(song);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdSong);
//    }
//
//    @PutMapping("/songs/{songId}")
//    public ResponseEntity<Song> updateSong(@PathVariable int songId, @RequestBody Song song) {
//        Song updatedSong = projectService.updateSong(songId, song);
//        if (updatedSong != null) {
//            return ResponseEntity.ok(updatedSong);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/songs/{songId}")
//    public ResponseEntity<Void> deleteSong(@PathVariable int songId) {
//        boolean deleted = projectService.deleteSong(songId);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/{projectId}/songs")
//    public ResponseEntity<List<Song>> getAllSongsForProject(@PathVariable int projectId) {
//        List<Song> songs = projectService.getAllSongsForProject(projectId);
//        return ResponseEntity.ok(songs);
//    }
//
//    @GetMapping("/{projectId}/songs/{songId}")
//    public ResponseEntity<Song> getSongForProjectById(@PathVariable int projectId, @PathVariable int songId) {
//        Song song = projectService.getSongForProjectById(projectId, songId);
//        if (song != null) {
//            return ResponseEntity.ok(song);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/{projectId}/songs")
//    public ResponseEntity<Song> addSongToProject(@PathVariable int projectId, @RequestBody Song song) {
//        Song addedSong = projectService.addSongToProject(projectId, song);
//        if (addedSong != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(addedSong);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{projectId}/songs/{songId}")
//    public ResponseEntity<Void> removeSongFromProject(@PathVariable int projectId, @PathVariable int songId) {
//        boolean removed = projectService.removeSongFromProject(projectId, songId);
//        if (removed) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/{projectId}/files")
//    public ResponseEntity<List<File>> getAllFilesForProject(@PathVariable int projectId) {
//        List<File> files = projectService.getAllFilesForProject(projectId);
//        return ResponseEntity.ok(files);
//    }
//
//    @PostMapping("/{projectId}/files")
//    public ResponseEntity<File> addFileToProject(@PathVariable int projectId, @RequestBody File file) {
//        File addedFile = projectService.addFileToProject(projectId, file);
//        if (addedFile != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(addedFile);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{projectId}/files/{fileId}")
//    public ResponseEntity<Void> removeFileFromProject(@PathVariable int projectId, @PathVariable int fileId) {
//        boolean removed = projectService.removeFileFromProject(projectId, fileId);
//        if (removed) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/files")
//    public ResponseEntity<List<File>> getAllFiles() {
//        List<File> files = projectService.getAllFiles();
//        return ResponseEntity.ok(files);
//    }
//
//    @GetMapping("/files/{fileId}")
//    public ResponseEntity<File> getFileById(@PathVariable int fileId) {
//        File file = projectService.getFileById(fileId);
//        if (file != null) {
//            return ResponseEntity.ok(file);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping("/files")
//    public ResponseEntity<File> createFile(@RequestBody File file) {
//        File createdFile = projectService.createFile(file);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdFile);
//    }
//
//    @PutMapping("/files/{fileId}")
//    public ResponseEntity<File> updateFile(@PathVariable int fileId, @RequestBody File file) {
//        File updatedFile = projectService.updateFile(fileId, file);
//        if (updatedFile != null) {
//            return ResponseEntity.ok(updatedFile);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/files/{fileId}")
//    public ResponseEntity<Void> deleteFile(@PathVariable int fileId) {
//        boolean deleted = projectService.deleteFile(fileId);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
}
