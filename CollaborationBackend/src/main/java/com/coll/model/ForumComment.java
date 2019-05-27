package com.coll.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ForumComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fcommentid;
	
	@ManyToOne
	private Forum forumid;
	
	@Column(nullable=false)
	private String forumname;
	
	@Column(nullable=false)
    private String forumcomment;
	
	@Column(nullable=false)
	private Date fcommentdate;

	@Column(nullable=false, unique=true)
	private String username;
	
	@ManyToOne
	private User useremailid;

	public int getFcommentid() {
		return fcommentid;
	}

	public void setFcommentid(int fcommentid) {
		this.fcommentid = fcommentid;
	}

	public String getForumname() {
		return forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

	public String getForumcomment() {
		return forumcomment;
	}

	public void setForumcomment(String forumcomment) {
		this.forumcomment = forumcomment;
	}

	public Date getFcommentdate() {
		return fcommentdate;
	}

	public void setFcommentdate(Date fcommentdate) {
		this.fcommentdate = fcommentdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
