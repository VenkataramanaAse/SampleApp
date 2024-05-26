package com.example.demo.serviceimpl;

import java.io.IOException;  
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.User;
import com.example.demo.Exceptions.EmailExistException;
import com.example.demo.Exceptions.InvalidEmailException;
import com.example.demo.Exceptions.InvalidPhnumberException;
import com.example.demo.Exceptions.PhnoExistException;
import com.example.demo.Repos.User_Repo;
import com.example.demo.Service.User_Service;
@Service
public class User_Serviceimpl implements User_Service {
      @Autowired
	  private User_Repo userRepo;
  
      public User saveUser(User user)throws InvalidPhnumberException {
    	  if (!isValidPhoneNumber(user.getUser_Phno())) {
              throw new InvalidPhnumberException("Invalid phone number");
          }
    	  else if (!isEmailValid(user.getUser_Email())){
              throw new InvalidEmailException("Invalid email address: " + user.getUser_Email());
          }
//  	  else if(userRepo.existsByUser_Email(user.getUser_Email())) {
//            throw new EmailExistException("Email already exists: " + user.getUser_Email());
//         }
//    	  else if(userRepo.existsByUser_Phno(user.getUser_Phno())) {
//    		  throw new PhnoExistException("ph no already exists: "+ user.getUser_Phno()); 
//    	  }
    	  
    	  
  
    	  
    	  
    	  return userRepo.save(user);
    	  
      }
      
      public List<User> get_Users(){
    	  
    	  
    	  return userRepo .findAll();
      }
      
      
      public void uploadImage(Integer userId, MultipartFile file) throws IOException {
          User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
          user.setImageData(file.getBytes());
          userRepo.save(user);
      }

      
      
      
      private boolean isValidPhoneNumber(Long phoneNumber) {
    	  if (phoneNumber == null) {
    	        return false;
    	    }
    	 
    	    
    	   
    	    String phoneNumberStr = String.valueOf(phoneNumber);
    	    return phoneNumberStr.length() == 10;
      }
      
      private boolean isEmailValid(String email) {
         
          return email != null && email.contains("@") && email.contains(".");
      }
	
      public void deleteUser(Integer userId) {
          userRepo.deleteById(userId);
      }
      
      public User updateEmail(Integer userId, String newEmail) throws InvalidEmailException {
          User user = userRepo.findById(userId)
                              .orElseThrow(() -> new IllegalArgumentException("User not found"));
          if (!isEmailValid(newEmail)) {
              throw new InvalidEmailException("Invalid email address: " + newEmail);
          }
          user.setUser_Email(newEmail.trim());
          return userRepo.save(user);
      }
      
      public User updatePhoneNumber(Integer userId, Long newPhoneNumber) throws InvalidPhnumberException {
          User user = userRepo.findById(userId)
                              .orElseThrow(() -> new IllegalArgumentException("User not found"));
          if (!isValidPhoneNumber(newPhoneNumber)) {
              throw new InvalidPhnumberException("Invalid phone number");
          }
          user.setUser_Phno(newPhoneNumber);
          return userRepo.save(user);
      }
      public boolean authenticate(String user_Email, String password) {
	        User user = userRepo.findByUser_Email(user_Email);
           if(user==null) {
        	   
        	   return false;
           }
           
           else {
        	   boolean isPassMatch=(BCrypt.checkpw(password,user.getPassword()));
   	        
        	   
   	        if (user !=null&&isPassMatch) {
   	        	
   	        	return true;
   	        	
   	        }
   	         
   	        	return false;
   	        	
           }
	    }
      
      public User getUserByEmail(String userEmail) {
    	    return userRepo.findByUser_Email(userEmail);
    	}
      
}
