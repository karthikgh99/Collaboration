package com.coll.restcontroller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.BlogCommentDAO;
import com.coll.model.BlogComment;
import com.coll.model.User;

@RestController
public class BlogCommentRestController 
{
@Autowired
BlogCommentDAO blogCommentDAO;

@GetMapping("/listBlogComments/{blogId}")
public ResponseEntity<List<BlogComment>> listBlogComment(@PathVariable("blogId") int blogId)
{
	List<BlogComment> listBlogComment=blogCommentDAO.listBlogComment(blogId);
	
	if(listBlogComment.size()>0)
	{
	return new ResponseEntity<List<BlogComment>>(listBlogComment,HttpStatus.OK);
}
	else
	{
		return new ResponseEntity<List<BlogComment>>(listBlogComment,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}

@PostMapping(value="/addBlogComment")
public ResponseEntity<?> addBlogComment(@RequestBody BlogComment blogComment ,HttpSession session)
{
	User u=(User) session.getAttribute("loggedinuser");
	blogComment.setUser(u);
	blogComment.setCommentedon(new Date());
	System.out.println(blogComment.getBlog().getBlogid()+" "+blogComment.getBlog().getBlogname());
	if (blogCommentDAO.addBlogComment(blogComment))
	{
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem Occured while Adding BlogComment",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}

@GetMapping(value="/getBlogComment/{commentId}")
public ResponseEntity<BlogComment> getBlogComment(@PathVariable("commentId")int commentId)
{
	BlogComment blogComment=blogCommentDAO.getBlogComment(commentId);
	
	if(blogComment!=null)
	{
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
}

@GetMapping(value="/deleteBlogComment/{commentId}")
public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId")int commentId)
{
	BlogComment blogComment=blogCommentDAO.getBlogComment(commentId);
	
	if(blogCommentDAO.deleteBlogComment(blogComment))
	{
		return new ResponseEntity<String>("Comment Deleted",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem occured while deleting",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
}
}