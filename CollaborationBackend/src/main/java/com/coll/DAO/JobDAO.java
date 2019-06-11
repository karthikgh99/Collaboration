package com.coll.DAO;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO {
	
	boolean addJob(Job job);

	boolean updateJob(Job job);

	boolean deleteJob(Job job);
	
	boolean showJob(Job job);

	
	List<Job> selectAllJob();

	Job getOneJob(int jobid);

}