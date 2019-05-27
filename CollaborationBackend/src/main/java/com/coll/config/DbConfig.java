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
		properties.put("hibernate.hbm2ddl.auto", "create");
		return properties;
	}
	
	
	@Bean (name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	    sessionBuilder.addAnnotatedClass(Blog.class);
	    sessionBuilder.addAnnotatedClass(BlogComment.class);
	    sessionBuilder.addAnnotatedClass(Forum.class);
	    sessionBuilder.addAnnotatedClass(ForumComment.class);
	    sessionBuilder.addAnnotatedClass(Friend.class);
	   // sessionBuilder.addAnnotatedClass(Job.class);
	    sessionBuilder.addAnnotatedClass(User.class);
	    System.out.println("Database Connected");
	    return sessionBuilder.buildSessionFactory();
	    
	}
	
	
	
	@Bean(name = "transcationManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	

}
