package com.coll.DAO;

import org.springframework.stereotype.Repository;

import com.coll.model.User;
@Repository("userDAO")
public interface UserDAO {

	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User checkUser(String emailid,String password);
	public User getUser(String emailid);
	

}
