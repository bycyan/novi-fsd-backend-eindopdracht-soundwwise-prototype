package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.File;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public ResponseEntity<List<File>> getAllFiles() {
        List<File> files = fileService.getAllFiles();
        return ResponseEntity.ok(files);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<Optional<File>> getFileById(@PathVariable int fileId) {
        Optional<File> file = fileService.getFileById(fileId);
        if (file.isPresent()) {
            return ResponseEntity.ok(file);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<File> createFile(@RequestBody File file) {
        File createdFile = fileService.createFile(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFile);
    }

    @PutMapping("/{fileId}")
    public ResponseEntity<File> updateFile(@RequestBody File file) {
        File updatedFile = fileService.updateFile(file);
        if (updatedFile != null) {
            return ResponseEntity.ok(updatedFile);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<Void> deleteFile(@PathVariable int fileId) {
        Optional<File> optionalFile = fileService.getFileById(fileId);
        if (optionalFile.isPresent()) {
            File file = optionalFile.get();
            boolean deleted = fileService.deleteFile(file);
            if (deleted) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}

