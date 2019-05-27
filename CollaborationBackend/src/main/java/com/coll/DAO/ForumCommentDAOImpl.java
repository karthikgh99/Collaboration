package com.coll.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.ForumComment;

@Repository
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addForumComment(ForumComment forumComment)  {
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	@Override
	public boolean deleteForumComment(ForumComment forumComment){
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public ForumComment getForumComment(int fcommentid) {
		try
		{
			return(ForumComment)sessionFactory.getCurrentSession().createQuery("from ForumComment where fcommentid="+fcommentid).uniqueResult();
		}
		catch (Exception e) {
		
		return null;
	}
	}
	@Override
	public List<ForumComment> listForumComment(int forumid) {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from ForumComment").list();
		}
		catch (Exception e) {
		return null;
	}
	}

}