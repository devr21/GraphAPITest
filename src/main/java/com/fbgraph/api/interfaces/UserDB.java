package com.fbgraph.api.interfaces;

import java.util.UUID;

import com.fbgraph.api.exceptions.NoSuchUserException;
import com.fbgraph.api.exceptions.UserException;
import com.fbgraph.api.model.Token;
import com.fbgraph.api.model.User;

public interface UserDB {

	User getUser(String userId) throws NoSuchUserException;
	void addUser(User user) throws UserException;	
	void setToken(String userId,Token token);
	
}
