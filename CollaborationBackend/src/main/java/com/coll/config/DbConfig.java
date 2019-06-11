package com.coll.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Forum;
import com.coll.model.ForumComment;
import com.coll.model.Friend;
import com.coll.model.Job;
import com.coll.model.ProfilePicture;
import com.coll.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ="com.coll")
public class DbConfig {
	
	@Bean(name = "dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		dataSource.setUsername("karthi");
		dataSource.setPassword("12345");
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	
	@Bean (name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionFactoryBuilder.addProperties(getHibernateProperties());
	    sessionFactoryBuilder.addAnnotatedClass(Blog.class);
	    sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
	    sessionFactoryBuilder.addAnnotatedClass(Forum.class);
	    sessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
	    sessionFactoryBuilder.addAnnotatedClass(Friend.class);
	   // sessionFactoryBuilder.addAnnotatedClass(Job.class);
	    sessionFactoryBuilder.addAnnotatedClass(User.class);
	    sessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
	    
	    System.out.println("Database Connected");
	    return sessionFactoryBuilder.buildSessionFactory();
	    
	}
	
	
	
	@Bean(name = "transcationManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	

}
