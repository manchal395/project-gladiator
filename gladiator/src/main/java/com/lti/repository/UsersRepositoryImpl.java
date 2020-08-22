package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Users;

@Repository
public class UsersRepositoryImpl implements UsersRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public void addUsers(Users users) {
		entityManager.merge(users);
	}
	
	@Override
	public Users fetchUserById(int id) {
		return entityManager.find(Users.class, id);
	}
	
	@Override
	public List<Users> fetchAllUsers() {
		return entityManager.createQuery("SELECT u FROM Users u").getResultList();
	}
	
	
	@Override      
	public boolean isUserPresent(String email) {
		return (long) entityManager.createQuery("select count(u.email) from Users u where u.email = :email")
				.setParameter("email", email)
				.getSingleResult() == 1 ? true:false;
	}
	
	@Override
	public int findByUsernamePassword(String email, String password) {
		return (Integer) entityManager.createQuery("select u.id from Users u where u.email = :email and u.password = :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
	}


}
