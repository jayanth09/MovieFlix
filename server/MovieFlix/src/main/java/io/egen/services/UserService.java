package io.egen.services;

import java.util.List;

import org.springframework.stereotype.Component;

import io.egen.entity.User;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;


@Component
public interface UserService {
	public List<User> findAll();
	public User findOne(String id) throws EntityNotFoundException;
	public User userAuth(String email, String pwd);
	public User create(User user) throws EntityAlreadyExistException;
	public User update(String id, User user) throws EntityNotFoundException;
	public void delete(String id);
}
