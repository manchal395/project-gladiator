package com.lti.exception;

public class AdminServiceException extends RuntimeException {

	public AdminServiceException() {
		super();
	}

	public AdminServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AdminServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AdminServiceException(String arg0) {
		super(arg0);
	}

	public AdminServiceException(Throwable arg0) {
		super(arg0);
	}
	

}
