package com.coll.CllaboratioBackend;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.JobDAO;

public class JobDAOTestCase 
{
	
	static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
				
	}
	
	
	

}
