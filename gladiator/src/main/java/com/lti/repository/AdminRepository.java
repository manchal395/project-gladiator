package com.lti.repository;

import com.lti.entity.Admin;

public interface AdminRepository {

	Admin fetchAdminById(int id);

	int findByUsernamePassword(String email, String password);

}