package io.egen.repository;

import java.util.List;

import javax.persistence.NoResultException;

import io.egen.entity.User;

public interface UserRepository {
	public List<User> findAll();
	public User findOne(String id);
	public User userAuth(String email, String pwd) throws NoResultException;
	public User findbyEmail(String email);
	public User create(User user);
	public User update(User user);
	public void delete(User user);
}
