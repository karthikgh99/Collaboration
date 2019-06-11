package com.coll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.coll")
public class WebResolver
{
	
//	@Bean
//    public InternalResourceViewResolver getViewResolver()
//    {
//		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/jsp");
//		resolver.setSuffix(".jsp");
//		System.out.println("---View Resolver ----");
//		return resolver;
//    }
	
	@Bean
	public CommonsMultipartResolver getMultipartResolver()
	{
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(4000000);
		return resolver;
	}
}

