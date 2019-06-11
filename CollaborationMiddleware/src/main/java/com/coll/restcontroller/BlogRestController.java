package com.coll.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.BlogDAO;
import com.coll.model.Blog;
import com.coll.model.User;

@RestController
public class BlogRestController 
{
@Autowired
BlogDAO blogDAO;

@GetMapping ("/showAllBlogs")
public ResponseEntity<List<Blog>> showAllBlogs(HttpSession session)
{List<Blog> blogList=null;
	User u=(User) session.getAttribute("loggedinuser");
	System.out.println(u.getRole());
	if(u.getRole().equals("ROLE_ADMIN"))
	{
	blogList=blogDAO.listBlogs("NA");
	System.out.println("Blog List Size:"+blogList.size());
	}
	if(u.getRole().equals("ROLE_USER"))
	{
		blogList=blogDAO.listBlogs("A");
		System.out.println("Blog List Size:"+blogList.size());
	}
	
	
	if(blogList.size()>0)
	{
		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@PostMapping("/addBlog")
public ResponseEntity<String> addBlog(@RequestBody Blog blog,HttpSession session)
{
	User u=(User) session.getAttribute("loggedinuser");
	blog.setCreatedate(new java.util.Date());
	blog.setLikes(1);
	blog.setDislike(0);
	blog.setStatus("NA");
	blog.setUser(u);
	
	if(blogDAO.addBlog(blog))
	{
		return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem Occured",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

@GetMapping("/deleteBlog/{blogId}")
public ResponseEntity<String> deleteBlog(@PathVariable("blogId")int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	 
	if(blogDAO.deleteBlog(blog))
	 {
		 return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<String>("Blog Deletion Problem",HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
}

@GetMapping("/incrementLikes/{blogId}")
public ResponseEntity<?> incrementLikes(@PathVariable("blogId")int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.incrementLikes(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Blog likes increment Problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

@GetMapping("/incrementDisLikes/{blogId}")
public ResponseEntity<?> incrementDisLikes(@PathVariable("blogId")int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.incrementDislikes(blog))
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Blog Dislikes increment Problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

@GetMapping("/approveBlog/{blogId}")
public ResponseEntity<String> approveBlog(@PathVariable("blogId")int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.approveBlog(blog))
	{
		return new ResponseEntity<String>("Blog Approved",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Blog Approve Problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

@GetMapping("/rejectBlog/{blogId}")
public ResponseEntity<String> rejectBlog(@PathVariable("blogId")int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blogDAO.rejectBlog(blog))
	{
		return new ResponseEntity<String>("Blog Rejected",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Blog Rejection Problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

@GetMapping("/getBlog/{blogId}")
public ResponseEntity<Blog> getBlog(@PathVariable("blogId")int blogId)
{
	Blog blog=blogDAO.getBlog(blogId);
	
	if(blog!=null)
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Blog>(blog,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

@PostMapping(value="/updateBlog")
public ResponseEntity<String> updateBlog(@RequestBody Blog blog)
{
	if(blogDAO.updateBlog(blog))
	{
		return new ResponseEntity<String>("Blog Updated",HttpStatus.OK);
	}
else
{
	return new ResponseEntity<String>("Problem occured while updating",HttpStatus.INTERNAL_SERVER_ERROR);
}
}
	}



