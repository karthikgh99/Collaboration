package com.coll.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.UserDAO;
import com.coll.model.User;

@RestController
public class UserRestController 
{
	@Autowired
	UserDAO userDAO;

	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		user.setRole("ROLE_USER");
		user.setIsonline(false);
		user.setStatus("A");
		if(userDAO.registerUser(user))
		{
	return new ResponseEntity<String>("New User Registered",HttpStatus.OK);
	
}
else
{
	return new ResponseEntity<String>("Problem while registering",HttpStatus.INTERNAL_SERVER_ERROR);
}
	}

	@GetMapping("/getuser/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username")String username)
	{
		User user=userDAO.getUser(username);
		 if (user!=null)
		 {
			 return new ResponseEntity<User>(user,HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUser(@PathVariable("username")String username,@RequestBody User user)
	{
		User user1=userDAO.getUser(username);
		user1.setName(user.getName());
		user1.setEmailid(user.getEmailid());
		user1.setPassword(user.getPassword());
		if(userDAO.updateUser(user1))
		{
			return new ResponseEntity<String>("User detail Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem occured while Updating",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@PostMapping("/checkUser")
	public ResponseEntity<User> checkUser(@RequestBody User user,HttpSession session)
	{
		User user1=userDAO.checkUser(user.getEmailid(),user.getPassword());
		
		if(user1!=null)
		{
			session.setAttribute("user",user1);
			return new ResponseEntity<User>(user1,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(user1,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
}
