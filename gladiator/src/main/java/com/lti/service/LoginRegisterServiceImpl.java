package com.lti.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Users;
import com.lti.exception.UsersServiceException;
import com.lti.repository.UsersRepository;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService   {

	@Autowired
	private UsersRepository usersRepo;
	
	
	@Override
	public void register(Users user) {
		if(!usersRepo.isUserPresent(user.getEmail())) {
			String tempPassword=user.getPassword();
			String encodedPassword=Base64.getEncoder().withoutPadding().encodeToString(tempPassword.getBytes());		
			user.setPassword(encodedPassword);
			usersRepo.addUsers(user);
		}
		else {
			throw new UsersServiceException("User Exists");
		}
	}
	
	@Override
	public  Users login(String email,String password) {
		//try {
			int id=usersRepo.findByUsernamePassword(email, password);
			Users user=usersRepo.fetchUserById(id);
			return user;
		//}
		/*catch(EmptyResultDataAccessException e) {
			throw new UsersServiceException(" Invalid username/password");
		}*/
		
	}
	
}
