package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Blog;

public interface BlogRepo extends JpaRepository<Blog,Integer>{
	

}
