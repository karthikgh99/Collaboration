package com.coll.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.Friend;
import com.coll.model.User;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
@Autowired
SessionFactory sessionFactory;

@Override
public List<Friend> showFriendList(String loginName)
{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Friend where username=:login and status='A'");
	query.setParameter("login", loginName);
	return null;
}

@Override
public List<Friend> showPendingFriendRequest(String loginName)
{Session session=sessionFactory.openSession();
Query query=session.createQuery("from Friend where username=:login and status='P'");
query.setParameter("login", loginName);
return null;
}


@Override
public boolean sendFriendRequest(Friend friend)
{
	try
	{
		friend.setStatus("P");
		sessionFactory.getCurrentSession().save(friend);
	return true;
	}
	catch(Exception e)
	{
		return false;
	}
}

@Override
public List<User> showSuggestedFriend(String loginName) {
	Session session=sessionFactory.openSession();
	SQLQuery sql=session.createSQLQuery("select * from userdata where username in("
			+ "select username from userdata where username!=:loginusername minus"
			+ "(select friendusername from Friend where username=:login"
			+ "union select username from Friend where friendusername=:login))");
	sql.setParameter("loginusername", loginName);
	sql.setParameter("login",loginName);
	sql.setParameter("login",loginName);
	List<User> usernamelist=sql.list();
	return usernamelist;
}

@Override
public boolean acceptFriendRequest(int friendId) 
{
	try
	{
		Session session=sessionFactory.openSession();
		Friend friend=session.get(Friend.class, friendId);
		session.close();
		friend.setStatus("A");
		sessionFactory.getCurrentSession().update(friend);
		return true;
		
	}
	catch (Exception e)
	{
		return false;
	}
}

@Override
public boolean deleteFriendRequest(int friendId) 
{
	try
	{
		Session session=sessionFactory.openSession();
		Friend friend=session.get(Friend.class,friendId);
		session.close();
		sessionFactory.getCurrentSession().delete(friend);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
}


}
