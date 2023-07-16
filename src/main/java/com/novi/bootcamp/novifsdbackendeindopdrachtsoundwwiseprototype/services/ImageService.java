//package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;
//
//import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.FileUploadResponse;
//import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.FileUploadRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.Objects;
//
//@Service
//public class ImageService {
//    private final String fileStorageLocation;
//    private final FileUploadRepository fileUploadRepository;
//
//    public ImageService(@Value("${my.upload_location}") String fileStorageLocation,
//                        FileUploadRepository fileUploadRepository) {
//        Path fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
//
//        this.fileStorageLocation = fileStorageLocation;
//        this.fileUploadRepository = fileUploadRepository;
//
//        try {
//            Files.createDirectories(fileStoragePath);
//        } catch (IOException e) {
//            throw new RuntimeException("Issue in creating file directory", e);
//        }
//    }
//
//    public String storeFile(MultipartFile file, String url) {
//        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//        Path filePath = Paths.get(fileStorageLocation + "/" + fileName);
//
//        try {
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new RuntimeException("Issue storing file", e);
//        }
//
//        fileUploadRepository.save(new FileUploadResponse(fileName, file.getContentType(), url));
//
//        return fileName;
//    }
//}
