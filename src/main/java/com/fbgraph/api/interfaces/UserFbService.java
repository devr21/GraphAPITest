package com.fbgraph.api.interfaces;

import com.fbgraph.api.exceptions.NoSuchUserException;
import com.fbgraph.api.model.User;

public interface UserFbService {

	public User fetchUserDataFromFB(String UserId) throws NoSuchUserException;
	
}
