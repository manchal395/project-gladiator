package com.lti.service;

import com.lti.entity.Users;

public interface LoginRegisterService {

	void register(Users user);

	Users login(String email, String password);

}