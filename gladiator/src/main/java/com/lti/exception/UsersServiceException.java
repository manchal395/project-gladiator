package com.lti.exception;

public class UsersServiceException extends RuntimeException {

	public UsersServiceException() {
		super();
	}

	public UsersServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsersServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsersServiceException(String message) {
		super(message);
	}

	public UsersServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
