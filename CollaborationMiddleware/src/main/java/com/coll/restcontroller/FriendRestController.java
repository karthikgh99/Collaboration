package com.coll.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.FriendDAO;
import com.coll.model.Friend;
import com.coll.model.User;

@RestController
public class FriendRestController 
{
	@Autowired
	
	FriendDAO friendDAO;
	@GetMapping(value="/showFriendList/{username}")
	public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username") String username)
	{
		List<Friend> friendList =friendDAO.showFriendList(username);
		if(friendList.size()>0)
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/pendingFriendList/{username}")
	public ResponseEntity<?> pendingFriendList(@PathVariable("username") String username)
	{
		List<Friend> pendingFriendList =friendDAO.showPendingFriendRequest(username);
		if(pendingFriendList!=null)
		{
			return new ResponseEntity<List<Friend>>(pendingFriendList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/suggestedFriendList/{username}")
	public ResponseEntity<List<User>> suggestedFriendList(@PathVariable("username") String username)
	{
		List<User> suggestedFriendList =friendDAO.showSuggestedFriend(username);
		if(suggestedFriendList.size()>0)
		{
			return new ResponseEntity<List<User>>(suggestedFriendList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<User>>(suggestedFriendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/acceptFriendRequest/{friendId}")
	public ResponseEntity<?> acceptFriendRequest(@PathVariable("friendId") int friendId)
	{
		Friend f=friendDAO.getFriend(friendId);
		if(friendDAO.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<Friend>(f,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in accepting friend Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId") int friendId)
	{
		
		if(friendDAO.deleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Friend Request Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in deleting friend Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value="/sendFriendRequest")
	public ResponseEntity<?> sendFriendRequest(@RequestBody Friend friend,HttpSession session)
	{
		User u=(User) session.getAttribute("loggedinuser");
		friend.setUsername(u.getUsername());
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in sending friend Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
