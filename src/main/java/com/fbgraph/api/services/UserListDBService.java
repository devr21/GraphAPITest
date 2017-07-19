package com.fbgraph.api.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.inject.Singleton;



import com.fbgraph.api.exceptions.NoSuchUserException;
import com.fbgraph.api.exceptions.UserException;
import com.fbgraph.api.interfaces.UserDB;
import com.fbgraph.api.model.Token;
import com.fbgraph.api.model.User;

@Named
@Singleton
public class UserListDBService implements UserDB{

	private Map<String,User> users = new HashMap<String,User>();

	public User getUser(String userId) throws NoSuchUserException {
		User user = users.get(userId);
		
		if(user == null)
			throw new NoSuchUserException("there is no user with user id : "+userId.toString());
		return user;
	}

	public void addUser(User user) throws UserException {
		if(user != null && user.getUserId() != null)
			users.put(user.getUserId().toString(), user);
		else 
			throw new UserException("There is a problem with user info: "+user.getUserId());
			
	}

	public void setToken(String userId, Token token) {
	
		User user = users.get(userId);
		user.setToken(token);
		users.put(userId, user);
	}
	
	@PreDestroy
	public void destroy(){
		users = null;
	}
	
}
