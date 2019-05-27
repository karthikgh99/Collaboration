package com.coll.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Forum {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int forumid;
	
	@Column(nullable=false)
	private String forumname;
	
	@Column(nullable=false)
	private String forumcontent;
	
	@ManyToOne
	private User useremailid;
	
	@Column(nullable=false)
	private Date createdate;
	
	@Column(nullable=false)
	private String status;

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getForumname() {
		return forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

	public String getForumcontent() {
		return forumcontent;
	}

	public void setForumcontent(String forumcontent) {
		this.forumcontent = forumcontent;
	}

	

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}