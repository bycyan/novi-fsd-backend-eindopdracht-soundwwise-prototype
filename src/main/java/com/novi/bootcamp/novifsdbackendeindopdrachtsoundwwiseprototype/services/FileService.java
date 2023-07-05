package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.File;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public Optional<File> getFileById(int fileId) {
        return fileRepository.findById(fileId);
    }

    public File createFile(File file) {
        return fileRepository.save(file);
    }

    public File updateFile(File file) {
        return fileRepository.save(file);
    }

    public boolean deleteFile(File file) {
        try {
            fileRepository.delete(file);
            return true; // Deletion succeeded
        } catch (Exception e) {
            // Handle any exceptions or errors
            return false; // Deletion failed
        }
    }
}

