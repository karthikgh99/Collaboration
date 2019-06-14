package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.JobDAO;
import com.coll.model.Blog;
import com.coll.model.Job;

@RestController
public class JobRestController 
{
	
	@Autowired
	JobDAO jobDAO;
	
   @PostMapping(value="/addJob")
   public ResponseEntity<?>addJob(@RequestBody Job job)
   {
	   System.out.println(job.getCTC());
	   if(jobDAO.addJob(job))
	   {
		   return new ResponseEntity<Job>(job,HttpStatus.OK);
	   }
	   else
	   {
		   return new ResponseEntity<String>("Error While Adding",HttpStatus.INTERNAL_SERVER_ERROR);
		   }
	   }
   
   @GetMapping(value="/showJobs")
   public ResponseEntity<List<Job>> showJobs()
   {
	   List<Job> jobList=jobDAO.selectAllJob();
	   
	   if(jobList.size()>0)
	   {
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   }

