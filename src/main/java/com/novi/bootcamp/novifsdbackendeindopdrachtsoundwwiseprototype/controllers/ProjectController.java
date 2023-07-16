package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.FileDTO;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.dtos.SongDTO;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.File;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.FileService;
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

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService, SongService songService, FileService fileService) {
        this.projectService = projectService;
    }

    //Projects
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

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Project project) {
        boolean deleted = projectService.deleteProject(project);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Contributors
    @GetMapping("/{projectId}/contributors")
    public ResponseEntity<List<String>> getContributorsByProjectId(@PathVariable int projectId) {
        Optional<Project> optionalProject = projectService.getProjectById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            List<String> contributors = project.getContributors();
            return ResponseEntity.ok(contributors);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{projectId}/contributors")
    public ResponseEntity<Project> addContributorToProject(
            @PathVariable int projectId,
            @RequestBody User contributor
    ) {
        Optional<Project> optionalProject = projectService.getProjectById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();

            // Extract first and last name from the contributor
            String contributorName = contributor.getFirstName() + " " + contributor.getLastName();

            project.addContributor(contributorName);

            Project updatedProject = projectService.updateProject(project);
            return ResponseEntity.ok(updatedProject);
        }
        return ResponseEntity.notFound().build();
    }


    // Remove a contributor from a project
    @DeleteMapping("/{projectId}/contributors/{contributorName}")
    public ResponseEntity<Void> removeContributorFromProject(
            @PathVariable int projectId,
            @PathVariable String contributorName
    ) {
        Optional<Project> optionalProject = projectService.getProjectById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            boolean contributorExists = project.getContributors().contains(contributorName);
            if (contributorExists) {
                project.removeContributor(contributorName);
                projectService.updateProject(project);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }


    //Songs
    @GetMapping("/{projectId}/songs")
    public ResponseEntity<List<SongDTO>> getAllSongsByProjectId(@PathVariable int projectId) {
        List<Song> songs = SongService.getSongsByProjectId(projectId);
        List<SongDTO> songDTOs = new ArrayList<>();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("project-id", String.valueOf(projectId));

        for (Song song : songs) {
            SongDTO songDTO = new SongDTO();
            songDTO.setSongId(song.getSongId());
            songDTO.setTitle(song.getTitle());
            songDTO.setArtist(song.getArtist());
            songDTO.setFilename(song.getFilename());
            songDTO.setFilePath(song.getFilePath());
            songDTOs.add(songDTO);
        }

        return ResponseEntity.ok().headers(responseHeaders).body(songDTOs);
    }

    //Files
    @GetMapping("/{projectId}/files")
    public ResponseEntity<List<FileDTO>> getAllFilesByProjectId(@PathVariable int projectId) {
        List<File> files = FileService.getFilesByProjectId(projectId);
        List<FileDTO> fileDTOs = new ArrayList<>();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("project-id", String.valueOf(projectId));

        for (File file : files) {
            FileDTO fileDTO = new FileDTO();
            fileDTO.setFileId(file.getFileId());
            fileDTO.setFileName(file.getFileName());
            fileDTO.setFileUrl(file.getFileUrl());
            fileDTOs.add(fileDTO);
        }

        return ResponseEntity.ok().headers(responseHeaders).body(fileDTOs);
    }


}
