package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Song;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
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
}
