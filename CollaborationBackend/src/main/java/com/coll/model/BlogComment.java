package com.coll.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BlogComment {

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogcommentid;
	private String commentdata;
	private Date commentedon;
	
	@ManyToOne
	Blog blog;
	
	
	@ManyToOne
	private User user;
	
	
	public String getCommentdata() {
		return commentdata;
	}


	public void setCommentdata(String commentdata) {
		this.commentdata = commentdata;
	}


	public int getBlogcommentid() {
		return blogcommentid;
	}


	public void setBlogcommentid(int blogcommentid) {
		this.blogcommentid = blogcommentid;
	}


	public Date getCommentedon() {
		return commentedon;
	}


	public void setCommentedon(Date commentedon) {
		this.commentedon = commentedon;
	}


	public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	
	
}