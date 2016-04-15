package io.egen.services;

import java.util.List;

import org.springframework.stereotype.Component;

import io.egen.entity.User;
import io.egen.exception.UserAlreadyExistException;
import io.egen.exception.UserNotFoundException;

@Component
public interface UserService {
	public List<User> findAll();
	public User findOne(String id) throws UserNotFoundException;
	public User create(User user) throws UserAlreadyExistException;
	public User update(String id, User user) throws UserNotFoundException;
	public void delete(String id);
}
