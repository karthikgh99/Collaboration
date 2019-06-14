package com.coll.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coll.model.Job;

@Repository("jobDAO")
public interface JobDAO {
	
	boolean addJob(Job job);

	boolean updateJob(Job job);

	boolean deleteJob(Job job);
	
	List<Job> selectAllJob();

	Job getOneJob(int jobid);

}