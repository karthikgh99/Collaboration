package com.coll.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO{

	
	@Autowired
	SessionFactory sessionFactory;
		@Override
		public boolean addBlog(Blog blog) {
			try
			{
				sessionFactory.getCurrentSession().save(blog);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}
		@Override
		public boolean deleteBlog(Blog blog){
			try
			{
				sessionFactory.getCurrentSession().delete(blog);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

		@Override
		public boolean updateBlog(Blog blog){
			try
			{
				sessionFactory.getCurrentSession().update(blog);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

		@Override
		public Blog getBlog(int blogid) {
			try
			{
				return(Blog)sessionFactory.getCurrentSession().createQuery("from Blog where blogid="+blogid).uniqueResult();
			}
			catch (Exception e) {
			
			return null;
		}
		}
		@Override
		public List<Blog> listBlogs(String status) {
			try
			{
				return sessionFactory.getCurrentSession().createQuery("from Blog where status='"+status+"'").list();
			}
			catch (Exception e) {
			return null;
		}
		}
		@Override
		public boolean approveBlog(Blog blog) {
			try
			{
				blog.setStatus("A");
				sessionFactory.getCurrentSession().update(blog);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

		@Override
		public boolean rejectBlog(Blog blog) {
			try
			{
				blog.setStatus("R");
				sessionFactory.getCurrentSession().update(blog);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

		@Override
		public boolean incrementLikes(Blog blog) {
			try
			{
				blog.setLikes(blog.getLikes()+1);
				sessionFactory.getCurrentSession().update(blog);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

		@Override
		public boolean incrementDislikes(Blog blog) {
			try
			{
				blog.setDislike(blog.getDislike()+1);
				sessionFactory.getCurrentSession().update(blog);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

	}
