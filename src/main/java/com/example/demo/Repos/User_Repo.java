package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.User;

public interface User_Repo extends JpaRepository<User, Integer> {
	
//		 boolean existsByUser_Email(String user_Email);
//	   boolean existsByUser_Phno(Long user_Phno);
	@Query("SELECT u FROM User u WHERE u.user_Email = :user_Email")
	  User findByUser_Email(@Param("user_Email") String user_Email);
	
	
	

}
