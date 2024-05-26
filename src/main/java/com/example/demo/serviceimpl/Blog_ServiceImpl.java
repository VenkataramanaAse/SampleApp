package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Blog;
import com.example.demo.Repos.BlogRepo;
import com.example.demo.Service.Blog_Service;
@Service
public class Blog_ServiceImpl implements Blog_Service {

	
	@Autowired
	private BlogRepo repo;
	 public Blog saveBlog(Blog blog) {
	        return repo.save(blog);

	 }
	 
	 
	 public List<Blog> getAllBlogs() {
	        return repo.findAll();
	    }
	 
	 public void deleteBlog(Integer id) {
			Optional<Blog> opt=repo.findById(id);
			if(opt.isPresent())
			{
				repo.deleteById(id);
			}
			else {
				//
			}
			
		}
	 
	 
	 public Blog getOneBlog(Integer id) {
			Optional<Blog> opt=repo.findById(id);
			
			if(opt.isPresent())
			{
				Blog b=opt.get();
				return b;
			}
			else {
			System.out.println("id is not present");
			}
			return null;
		}
	 
	 
	 public void update(Blog b) {
		 repo.save(b);
	 }
		
}
