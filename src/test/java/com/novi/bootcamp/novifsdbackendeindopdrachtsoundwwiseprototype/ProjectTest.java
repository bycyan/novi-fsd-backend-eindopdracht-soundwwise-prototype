package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.ProjectRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class ProjectTest {

    private ProjectRepository projectRepository;
    private ProjectService projectService;

    @BeforeEach
    public void setup() {
        projectRepository = Mockito.mock(ProjectRepository.class);
        projectService = new ProjectService(projectRepository);
    }

    @Test
    public void testAddContributorToProject_Success() {
        // Arrange
        int projectId = 1;
        User contributor = new User(); // Replace with your User implementation

        Project existingProject = new Project();
        existingProject.setProjectId(projectId);

        Mockito.when(projectRepository.findById(projectId)).thenReturn(Optional.of(existingProject));
        Mockito.when(projectRepository.save(Mockito.any(Project.class))).thenReturn(existingProject);

        // Act
        Project result = projectService.addContributorToProject(projectId, (org.apache.catalina.User) contributor);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getContributors().size());
        Assertions.assertEquals(String.valueOf(contributor), result.getContributors().get(0));
        Mockito.verify(projectRepository, Mockito.times(1)).findById(projectId);
        Mockito.verify(projectRepository, Mockito.times(1)).save(existingProject);
    }

    @Test
    public void testAddContributorToProject_ProjectNotFound() {
        // Arrange
        int projectId = 1;
        User contributor = new User(); // Replace with your User implementation

        Mockito.when(projectRepository.findById(projectId)).thenReturn(Optional.empty());

        // Act
        Project result = projectService.addContributorToProject(projectId, (org.apache.catalina.User) contributor);

        // Assert
        Assertions.assertNull(result);
        Mockito.verify(projectRepository, Mockito.times(1)).findById(projectId);
        Mockito.verify(projectRepository, Mockito.never()).save(Mockito.any(Project.class));
    }
}
