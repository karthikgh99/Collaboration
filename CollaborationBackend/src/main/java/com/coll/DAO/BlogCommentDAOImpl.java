package com.coll.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.BlogComment;

	@Repository("blogcommentDAO")
	@Transactional
	public class BlogCommentDAOImpl implements BlogCommentDAO {
		
		@Autowired
		SessionFactory sessionFactory;

		@Override
		public boolean addBlogComment(BlogComment blogComment) {
			try
			{
				System.out.println(blogComment.getBlog().getBlogname());
				sessionFactory.getCurrentSession().save(blogComment);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}
		@Override
		public boolean deleteBlogComment(BlogComment blogComment) {
			try
			{
				sessionFactory.getCurrentSession().delete(blogComment);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}
		@Override
		public BlogComment getBlogComment(int commentid) {
			try
			{
				return(BlogComment)sessionFactory.getCurrentSession().createQuery("from BlogComment where commentid="+commentid).uniqueResult();
			}
			catch (Exception e) {
			
			return null;
		}
		}
		@Override
		public List<BlogComment> listBlogComment(int blogid) {
			try
			{
				return sessionFactory.getCurrentSession().createQuery("from BlogComment where blog.blogid="+blogid).list();
			}
			catch (Exception e) {
			return null;
		}
		}
	}

	