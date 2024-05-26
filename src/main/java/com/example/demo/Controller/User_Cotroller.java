package com.example.demo.Controller;

import java.awt.Image; 
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.User;
import com.example.demo.Repos.Loginrepo;
import com.example.demo.Service.User_Service;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import io.swagger.v3.oas.models.media.MediaType;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("User")

@Slf4j

@Validated
@Controller
public class User_Cotroller {
	@Autowired
   private User_Service userService;
	
	@PostMapping
	public ResponseEntity<User> user( @Valid @RequestBody User user){
		String hashedPass=BCrypt.hashpw(user.getPassword(), org.mindrot.jbcrypt.BCrypt.gensalt(12));
		user.setPassword(hashedPass);
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	@GetMapping
	
	public ResponseEntity<List<User>> get_Users(){
		return ResponseEntity.ok(userService.get_Users());
	}
	
	@PostMapping("/{userId}/image")
	
	public ResponseEntity<String> uploadImage(@PathVariable Integer userId, @RequestParam("image") MultipartFile file) {
	    try {
	        userService.uploadImage(userId, file);
	        return ResponseEntity.ok("Image uploaded successfully");
	    } catch (IOException e) {
	    	
	        return ResponseEntity.badRequest().body("Failed to upload image: " + e.getMessage());
	        
	    }
	}
	
	 @DeleteMapping("/users/{userId}")
	    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
	        userService.deleteUser(userId);
	        return new ResponseEntity<>("User deleted successfully.", HttpStatus.OK);
	    }	
	 
	 @PutMapping("/users/{userId}/email")
	    public ResponseEntity<?> updateEmail(@PathVariable Integer userId, @RequestBody String newEmail) {
	        try {
	            User updatedUser = userService.updateEmail(userId, newEmail);
	            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }

	    @PutMapping("/users/{userId}/")
	    public ResponseEntity<?> updatePhoneNumber(@PathVariable Integer userId, @RequestBody Long newPhoneNumber) {
	        try {
	        	
	            User updatedUser = userService.updatePhoneNumber(userId, newPhoneNumber);
	            
	            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	            
	        } catch (Exception e) {
	        	
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }
	    
	    @PostMapping("/login")
	     public ResponseEntity<String> login(@RequestParam String user_Email, @RequestParam String password) {
	        if (userService.authenticate(user_Email, password)) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }
	    }
	    
	    @GetMapping("/weblogin")
	    public String showLoginForm() {
	        return "Login";
	    }
	    
	    @PostMapping("/weblogin")
	    public String webLogin(@RequestParam String user_Email ,@RequestParam String password ,RedirectAttributes attribute ,HttpSession session) {
	    	if (userService.authenticate(user_Email, password)) {
	    		
	    		session.setAttribute("LoggedInUserEmail", user_Email);
	    		 LocalDateTime loginTime = LocalDateTime.now();
	    	        session.setAttribute("LoginTime", loginTime); 
	    	      
	    		System.out.println(user_Email);
	            return "redirect:userDetails";
	        } 
	    	else {
	    		attribute.addFlashAttribute("error", "Invalid email or password");
	    		return "redirect:weblogin";
	    	}
	    }
	    
	    @GetMapping("/userDetails")
	    public String getUserDetails(Model model, HttpSession session) {
	        String loggedInUserEmail = (String) session.getAttribute("LoggedInUserEmail");
	        System.out.println(loggedInUserEmail);
	        if (loggedInUserEmail != null) {
	           
	            User user = userService.getUserByEmail(loggedInUserEmail);
	            model.addAttribute("user", user);
	            return "User"; 
	        } else {
	          
	            return "redirect:weblogin";
	        }
	    }
	    
	    @GetMapping("/users")
	    public String getUsers(Model model) {
	        List<User> users = userService.get_Users();
	        model.addAttribute("users", users);
	        return "Users";        
	    }
	    
	   
	 
}
