package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.ProjectRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    //Projects
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
    public boolean deleteProject(Project project) {
        try {
            projectRepository.delete(project);
            return true; // Deletion succeeded
        } catch (Exception e) {
            // Handle any exceptions or errors
            return false; // Deletion failed
        }
    }

    // Contributors
    public Project addContributorToProject(int projectId, User contributor) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.addContributor(String.valueOf(contributor));
            return projectRepository.save(project);
        }
        return null; // Or throw an exception indicating project not found
    }

    public List<Project> getUserProjects(String userId) {
        Optional<com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User> user = userRepository.findByEmail(userId);
        if (user.isPresent()) {
            return user.get().getProjects();
        } else {
            return Collections.emptyList();
        }
    }
}
