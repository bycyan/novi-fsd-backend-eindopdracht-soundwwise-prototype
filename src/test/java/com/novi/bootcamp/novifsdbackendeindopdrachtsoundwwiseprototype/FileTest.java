package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.File;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.FileRepository;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.FileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileTest {

    @Mock
    private FileRepository fileRepository;

    private FileService fileService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        fileService = new FileService(fileRepository);
    }

    @Test
    public void testGetAllFiles() {
        // Arrange
        List<File> expectedFiles = new ArrayList<>();
        expectedFiles.add(new File(1, "File1", "file1.txt", null));
        expectedFiles.add(new File(2, "File2", "file2.txt", null));

        Mockito.when(fileRepository.findAll()).thenReturn(expectedFiles);

        // Act
        List<File> actualFiles = fileService.getAllFiles();

        // Assert
        Assertions.assertEquals(expectedFiles, actualFiles);
        Mockito.verify(fileRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetFileById() {
        // Arrange
        int fileId = 1;
        File expectedFile = new File(fileId, "File1", "file1.txt", null);

        Mockito.when(fileRepository.findById(fileId)).thenReturn(Optional.of(expectedFile));

        // Act
        Optional<File> actualFile = fileService.getFileById(fileId);

        // Assert
        Assertions.assertTrue(actualFile.isPresent());
        Assertions.assertEquals(expectedFile, actualFile.get());
        Mockito.verify(fileRepository, Mockito.times(1)).findById(fileId);
    }

    @Test
    public void testCreateFile() {
        // Arrange
        File fileToCreate = new File(1, "File1", "file1.txt", null);
        Mockito.when(fileRepository.save(fileToCreate)).thenReturn(fileToCreate);

        // Act
        File createdFile = fileService.createFile(fileToCreate);

        // Assert
        Assertions.assertEquals(fileToCreate, createdFile);
        Mockito.verify(fileRepository, Mockito.times(1)).save(fileToCreate);
    }

    @Test
    public void testUpdateFile() {
        // Arrange
        File fileToUpdate = new File(1, "File1", "file1.txt", null);
        Mockito.when(fileRepository.save(fileToUpdate)).thenReturn(fileToUpdate);

        // Act
        File updatedFile = fileService.updateFile(fileToUpdate);

        // Assert
        Assertions.assertEquals(fileToUpdate, updatedFile);
        Mockito.verify(fileRepository, Mockito.times(1)).save(fileToUpdate);
    }

    @Test
    public void testDeleteFile() {
        // Arrange
        File fileToDelete = new File(1, "File1", "file1.txt", null);

        // Act
        boolean deletionResult = fileService.deleteFile(fileToDelete);

        // Assert
        Assertions.assertTrue(deletionResult);
        Mockito.verify(fileRepository, Mockito.times(1)).delete(fileToDelete);
    }
}



