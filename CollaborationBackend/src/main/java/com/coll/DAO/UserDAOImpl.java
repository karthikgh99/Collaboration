package com.coll.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateUser(User user){
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public User checkUser(String emailid, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public User getUser(String emailid)
	{
		try
		{
			return(User)sessionFactory.getCurrentSession().createQuery("from User where emailid='"+emailid+"'").uniqueResult();
		}
		catch (Exception e) {
		
		return null;
	}
	}

	
	}

	

