package com.coll.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.Blog;
import com.coll.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO{

	
	@Autowired
	SessionFactory sessionFactory;
		@Override
		public boolean addJob(Job job) {
			try
			{
				System.out.println(job.getCTC());
				sessionFactory.getCurrentSession().save(job);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}
		@Override
		public boolean deleteJob(Job job){
			try
			{
				sessionFactory.getCurrentSession().delete(job);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

		@Override
		public boolean updateJob(Job job){
			try
			{
				sessionFactory.getCurrentSession().update(job);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}
		
		@Override
		public List<Job> selectAllJob() {
			try
			{
				return sessionFactory.getCurrentSession().createQuery("from Job ").list();
			}
			catch (Exception e) {
			return null;
		}
		}
		@Override
		public Job getOneJob(int jobid) {
			try
			{
				List<Job> joblist=sessionFactory.getCurrentSession().createQuery("from Job where jobId="+jobid).list();
				return joblist.get(0);
			}
			catch (Exception e) {
			return null;
		}
		}
}
