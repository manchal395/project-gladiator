package com.lti.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.lti.entity.Users;

public interface UsersRepository {

	void addUsers(Users users);

	Users fetchUserById(int id);

	List<Users> fetchAllUsers();

	boolean isUserPresent(String email);

	int findByUsernamePassword(String email, String password);

}