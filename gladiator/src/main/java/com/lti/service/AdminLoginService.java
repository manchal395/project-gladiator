package com.lti.service;

import com.lti.entity.Admin;

public interface AdminLoginService {

	Admin login(String email, String password);

}