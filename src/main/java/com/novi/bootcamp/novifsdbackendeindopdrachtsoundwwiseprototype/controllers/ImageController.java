//package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.controllers;
//
//import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.FileUploadResponse;
//import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services.ImageService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.util.Objects;
//
//@RestController
//@CrossOrigin
//public class ImageController {
//    private final ImageService imageService;
//
//    public ImageController(ImageService imageService) {
//        this.imageService = imageService;
//    }
//
//    @PostMapping("/upload")
//    FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
//        String url = ServletUriComponentsBuilder
//                .fromCurrentContextPath()
//                .path("/download")
//                .path(Objects.requireNonNull(file.getOriginalFilename()))
//                .toUriString();
//
//        String contentType = file.getContentType();
//        String fileName = imageService.storeFile(file, url);
//        return new FileUploadResponse(fileName, contentType, url);
//    }
//
//}
