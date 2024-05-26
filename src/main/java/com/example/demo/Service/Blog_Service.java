package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Blog;

public interface Blog_Service {

	
	public Blog saveBlog(Blog blog);
	
	 public List<Blog> getAllBlogs();
	 
	 public void deleteBlog(Integer id);
	 
	 public void update(Blog b) ;
	 
	 public Blog getOneBlog(Integer id);
}
