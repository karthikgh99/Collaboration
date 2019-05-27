package com.coll.CllaboratioBackend;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.coll.DAO.BlogDAO;
import com.coll.model.Blog;


public class BlogTest {

	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initilize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogid(1);
		blog.setBlogname("New blog");
		blog.setBlogcontent("new blog content");
		blog.setLikes(2);
		blog.setCreatedate(new Date());
		blog.setDislike(0);
		blog.setStatus("approved");
		assertTrue("error in adding blog",blogDAO.addBlog(blog));
		
		
	}
}
