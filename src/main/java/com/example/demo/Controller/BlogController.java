package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Blog;
import com.example.demo.Service.Blog_Service;



@Controller
public class BlogController {
	@Autowired
	private Blog_Service service;
	
	
	@GetMapping("/")
	public String home()
	{
		return "BlogHome";  
	}
	
	
	 @GetMapping("/newBlog")
	    public String showNewBlogForm(Model model) {
	        model.addAttribute("blog", new Blog());
	        return "BlogForm";
	    }
	 
	 
	  @PostMapping("/saveBlog")
	    public String saveBlog(@ModelAttribute("blog") Blog blog) {
	        service.saveBlog(blog);
	        System.out.println("suceessfully uploaded");
	        return "redirect:/showBlogs";
	    }
	  
	  @GetMapping("/delete")
		public String deleteById(@RequestParam Integer id ,Model model)
		{
			
			service.deleteBlog(id);
			
			return "redirect:showBlogs";
		}
	  
	  
	  @GetMapping("/showBlogs")
	    public String showAllBlogs(Model model) {
	        model.addAttribute("blogs", service.getAllBlogs());
	        return "AllBlogs";
	    }

	  @GetMapping("/Blogedit")
		public String edit(@RequestParam Integer id , Model model)
		{
		  
			
			Blog b=service.getOneBlog(id);
			
			if(b==null) {
				System.out.println("blog is null");
				return "ERROR";
				
			}
			model.addAttribute("blog",b);
			
			return "BlogUpdate";	
			
		}
	  
	  
	  @PostMapping("/update")
	  public String update(@ModelAttribute Blog b) {
		  service.update(b);
		  
		  return "redirect:showBlogs";
	  }
}
