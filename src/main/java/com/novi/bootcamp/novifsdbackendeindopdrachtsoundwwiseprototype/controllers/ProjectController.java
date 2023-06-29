package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //Retrieve all projects: Endpoint: GET /projects
    //Retrieve a specific project by ID: Endpoint: GET /projects/{projectId}

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    //Update an existing project: Endpoint: PUT /projects/{projectId}

    //Song
    //Retrieve all songs for a specific project: Endpoint: GET /projects/{projectId}/songs
    //Add a song to a project: Endpoint: POST /projects/{projectId}/songs, Request Body: JSON representation of the song object
    //Remove a song from a project: Endpoint: DELETE /projects/{projectId}/songs/{songId}

    //Content
    //Retrieve all content items for a specific project: Endpoint: GET /projects/{projectId}/contentItems
    //Add a content item to a project: Endpoint: POST /projects/{projectId}/contentItems
    //Remove a content item from a project: Endpoint: DELETE /projects/{projectId}/contentItems/{contentItemId}

}
