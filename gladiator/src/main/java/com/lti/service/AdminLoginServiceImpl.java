package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.exception.AdminServiceException;
import com.lti.repository.AdminRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	@Autowired
	private AdminRepository adminRepository;
	
	
	@Override
	public  Admin login(String email,String password) {
		try {
			int id=adminRepository.findByAdminUsernamePassword(email, password);
			Admin admin=adminRepository.fetchAdminById(id);
			return admin;
		}
		catch(EmptyResultDataAccessException e) {
			throw new AdminServiceException(" Invalid username/password");
		}

	}
}
