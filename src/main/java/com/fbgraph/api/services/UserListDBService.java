package com.fbgraph.api.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

	private Map<UUID,User> users = new HashMap<UUID,User>();

	public User getUser(UUID userId) throws NoSuchUserException {
		User user = users.get(userId);
		
		if(user == null)
			throw new NoSuchUserException("there is no user with user id : "+userId.toString());
		return null;
	}

	public void addUser(User user) throws UserException {
		if(user != null && user.getUserId() != null)
			users.put(user.getUserId(), user);
		else 
			throw new UserException("There is a problem with user info: "+user.getUserId());
			
	}

	public void setToken(UUID userId, Token token) {
	
		User user = users.get(userId);
		user.setToken(token);
		users.put(userId, user);
	}
	
}
