package com.coll.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.ProfilePicture;

@Repository
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
@Autowired
SessionFactory sessionFactory;

@Override
public void save(ProfilePicture profilePicture) 
{
	Session session=sessionFactory.openSession();
	session.saveOrUpdate(profilePicture);
	session.flush();
	session.close();	
}

@Override
public ProfilePicture getProfilePicture(String username) 
{
	Session session=sessionFactory.openSession();
	ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class,username);
	session.close();
	return null;
}
}
