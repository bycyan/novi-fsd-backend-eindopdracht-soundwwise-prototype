package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.services;

import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.models.User;
import com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
//    private final FileUploadRepository fileUploadRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

//    public void assignImageToUser(String fileName, int userId) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        Optional<FileUploadResponse> fileUploadResponse = fileUploadRepository.finByFileName(fileName);
//        if (optionalUser.isPresent() && fileUploadResponse.isPresent()){
//            FileUploadResponse image = fileUploadResponse.get();
//            User user = optionalUser.get();
//            user.setFile(image);
//            userRepository.save(user);
//        }
//    }
}
