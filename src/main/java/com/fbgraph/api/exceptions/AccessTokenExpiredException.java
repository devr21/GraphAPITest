package com.fbgraph.api.exceptions;

public class AccessTokenExpiredException extends TokenException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7976836454162618974L;

	public AccessTokenExpiredException(String message){
		super(message);
	}
	
}
