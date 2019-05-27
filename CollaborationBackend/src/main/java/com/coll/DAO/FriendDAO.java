package com.coll.DAO;

import java.util.List;

import com.coll.model.Friend;
import com.coll.model.User;

public interface FriendDAO {
	public List<Friend> showFriendList(String loginName);
	public List<Friend> showPendingFriendRequest(String loginName);
	public List<User> showSuggestedFriend(String loginName);
	

	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendRequest(int friendId);
    
}
