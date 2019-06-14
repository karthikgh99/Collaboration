package com.coll.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration)
	{
		System.out.println("Customize Registration");
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.setAsyncSupported(true);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		System.out.println("-- Get Root Config Classes --");
		return new Class[] {WebResolver.class,WebSocketconfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		System.out.println("-- Get Servlet Config Classes --");
		return new Class[] {DbConfig.class};
	}

	@Override
	protected String[] getServletMappings() 
	{	
		System.out.println("-- Get Servlet Mappings Classes --");
		return new String[] {"/"};
	}
	@Override
	protected Filter[] getServletFilters()
	{
		CharacterEncodingFilter encodingFilter=new CharacterEncodingFilter();
		encodingFilter.setEncoding(StandardCharsets.UTF_8.name());
		return new Filter[] {encodingFilter};
	}
}