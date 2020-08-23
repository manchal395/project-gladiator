package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Admin fetchAdminById(int id) {
		return entityManager.find(Admin.class, id);
	}
	
	@Override
	public int findByAdminUsernamePassword(String email, String password) {
		return (Integer) entityManager.createQuery("select a.id from Admin a where a.email = :email and a.password = :password").setParameter("email", email).setParameter("password", password).getSingleResult();
	}



}
