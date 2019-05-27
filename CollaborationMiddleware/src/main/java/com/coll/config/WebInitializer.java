package com.coll.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		System.out.println(" Get Root config Classes ");
		return new Class[] {WebResolver.class,DbConfig.class};
		
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	
}
