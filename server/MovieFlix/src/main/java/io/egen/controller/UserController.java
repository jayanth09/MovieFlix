package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.User;
import io.egen.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
		
	@Autowired
	private UserService service;
	
	public List<User> findAll() {
		return service.findAll();
	}
	
	public User findOne(String id) {
		return service.findOne(id);
	}
	
	public User create(User user) {
		return service.create(user);
	}
	
	public User update(String id, User user) {
		return service.update(id, user);
	}
	
	public User delete(String id) {
		return service.delete(id);
	}
}
