package com.example.demo.Service;

import java.io.IOException; 
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.User;
import com.example.demo.Exceptions.InvalidEmailException;
import com.example.demo.Exceptions.InvalidPhnumberException;

public interface User_Service {
	User saveUser(User user) throws InvalidPhnumberException;
    List<User> get_Users();
    
    public void deleteUser(Integer userId);
    public User getUserByEmail(String userEmail);
    void uploadImage(Integer userId, MultipartFile file) throws IOException;
    
    boolean authenticate(String user_Email, String password);
    
    User updateEmail(Integer userId, String newEmail) throws InvalidEmailException;

    User updatePhoneNumber(Integer userId, Long newPhoneNumber) throws InvalidPhnumberException;
}
