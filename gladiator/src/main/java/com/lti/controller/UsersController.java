package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Users;
import com.lti.exception.UsersServiceException;
import com.lti.service.LoginRegisterServiceImpl;

@RestController
@CrossOrigin
public class UsersController {
	@Autowired
	private  LoginRegisterServiceImpl loginRegisterService;
		
	//@RequestMapping(path = ..., method = POST, ...)
	@PostMapping("/register")
	public Status register(@RequestBody Users users) {
		try {
			loginRegisterService.register(users);
			
			
			Status status = new Status();
			status.setStatus(Status.StatusType.SUCCESS);
			status.setMessage("Registration Successful!");
			return status;
		}
		catch(UsersServiceException e) {
			Status status = new Status();
			status.setStatus(Status.StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	@PostMapping(path="/login",consumes = "application/json")
	public LoginStatus login(@RequestBody Users users) {
		try {
			Users user = loginRegisterService.login(users.getEmail(),users.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(Status.StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful!");
			loginStatus.setUserId(user.getId());
			loginStatus.setName(user.getFullName());
			return loginStatus;
		}
		catch(Exception e) { 
			LoginStatus status = new LoginStatus();

			if (e instanceof UsersServiceException) {
				status.setMessage(e.getMessage());
			} else {
				status.setMessage(e.getMessage());
			}

			status.setStatus(Status.StatusType.FAILURE);

			return status;
		}
	}
	
	public static class LoginStatus extends Status{
		private int userId;
		private String name;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		
		
	}
	
	
	public static class Status {
		private StatusType status;
		private String message;
		
		public static enum StatusType{
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}

}
	


