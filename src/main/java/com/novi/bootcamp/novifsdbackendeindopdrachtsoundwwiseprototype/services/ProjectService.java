package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(int projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }
}
