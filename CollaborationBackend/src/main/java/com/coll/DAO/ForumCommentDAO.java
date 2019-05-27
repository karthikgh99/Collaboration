package com.coll.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coll.model.ForumComment;
@Repository
public interface ForumCommentDAO {
	
	public boolean addForumComment(ForumComment forumComment);

	public boolean deleteForumComment(ForumComment forumComment);

	public ForumComment getForumComment(int fcommentid);

	public List<ForumComment> listForumComment(int forumid);
	

}