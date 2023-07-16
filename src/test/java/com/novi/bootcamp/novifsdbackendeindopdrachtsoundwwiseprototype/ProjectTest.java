package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.Project;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.ProjectRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.UserRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static org.mockito.Mockito.*;

public class ProjectTest {
    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectService projectService;

    public ProjectTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProjectById_ShouldReturnProjectById() {
        // Arrange
        int projectId = 1;
        Project project = new Project();
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

        // Act
        Optional<Project> result = projectService.getProjectById(projectId);

        // Assert
        Assertions.assertEquals(Optional.of(project), result);
        verify(projectRepository, times(1)).findById(projectId);
    }

    @Test
    void createProject_ShouldReturnCreatedProject() {
        // Arrange
        Project project = new Project();
        when(projectRepository.save(project)).thenReturn(project);

        // Act
        Project result = projectService.createProject(project);

        // Assert
        Assertions.assertEquals(project, result);
        verify(projectRepository, times(1)).save(project);
    }

    @Test
    void updateProject_ShouldReturnUpdatedProject() {
        // Arrange
        Project project = new Project();
        when(projectRepository.save(project)).thenReturn(project);

        // Act
        Project result = projectService.updateProject(project);

        // Assert
        Assertions.assertEquals(project, result);
        verify(projectRepository, times(1)).save(project);
    }

    @Test
    void deleteProject_DeletionSucceeds_ShouldReturnTrue() {
        // Arrange
        Project project = new Project();

        // Act
        boolean result = projectService.deleteProject(project);

        // Assert
        Assertions.assertTrue(result);
        verify(projectRepository, times(1)).delete(project);
    }

    @Test
    void deleteProject_DeletionFails_ShouldReturnFalse() {
        // Arrange
        Project project = new Project();
        doThrow(new RuntimeException()).when(projectRepository).delete(project);

        // Act
        boolean result = projectService.deleteProject(project);

        // Assert
        Assertions.assertFalse(result);
        verify(projectRepository, times(1)).delete(project);
    }


    @Test
    void getUserProjects_UserExists_ShouldReturnUserProjects() {
        // Arrange
        String userId = "user@example.com";
        com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User user =
                new com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User();
        List<Project> projects = Collections.singletonList(new Project());
        when(userRepository.findByEmail(userId)).thenReturn(Optional.of(user));
        when(user.getProjects()).thenReturn(projects);

        // Act
        List<Project> result = projectService.getUserProjects(userId);

        // Assert
        Assertions.assertEquals(projects, result);
        verify(userRepository, times(1)).findByEmail(userId);
        verify(user, times(1)).getProjects();
    }

    @Test
    void getUserProjects_UserNotExists_ShouldReturnEmptyList() {
        // Arrange
        String userId = "user@example.com";
        when(userRepository.findByEmail(userId)).thenReturn(Optional.empty());

        // Act
        List<Project> result = projectService.getUserProjects(userId);

        // Assert
        Assertions.assertTrue(result.isEmpty());
        verify(userRepository, times(1)).findByEmail(userId);
    }
}
