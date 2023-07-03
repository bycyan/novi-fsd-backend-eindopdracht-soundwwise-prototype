//package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;
//
//import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
//import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/projects")
//public class ProjectController {
//
//    private final ProjectService projectService;
//
//    @Autowired
//    public ProjectController(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    //Retrieve all projects: Endpoint: GET /projects
//    //Retrieve a specific project by ID: Endpoint: GET /projects/{projectId}
//
//    @PostMapping
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        Project createdProject = projectService.createProject(project);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
//    }
//
////    return new ResponseEntity<>(createdProject, HttpStatus.CREATED).body(createdProject);
//
//    //Update an existing project: Endpoint: PUT /projects/{projectId}
//
//    //Song
//    //Retrieve all songs for a specific project: Endpoint: GET /projects/{projectId}/songs
//    //Add a song to a project: Endpoint: POST /projects/{projectId}/songs, Request Body: JSON representation of the song object
//    //Remove a song from a project: Endpoint: DELETE /projects/{projectId}/songs/{songId}
//
//    //Content
//    //Retrieve all content items for a specific project: Endpoint: GET /projects/{projectId}/contentItems
//    //Add a content item to a project: Endpoint: POST /projects/{projectId}/contentItems
//    //Remove a content item from a project: Endpoint: DELETE /projects/{projectId}/contentItems/{contentItemId}
//
//}


package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.ProjectRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
//        Project existingProject = projectRepository.findById(id);
//        if (existingProject == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        project.setProjectId(existingProject.getProjectId());
//        Project updatedProject = projectRepository.save(project);
//        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") int id) {
//        Project project = projectRepository.findById(id);
//        if (project == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        projectRepository.delete(project);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
