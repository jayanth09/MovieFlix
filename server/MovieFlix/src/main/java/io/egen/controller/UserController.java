package io.egen.controller;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.User;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;
import io.egen.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
		
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String id) throws EntityNotFoundException {
		return service.findOne(id);
	}
	
	@RequestMapping(value="/{email}/{password}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User userAuth(@PathVariable("email") String email, @PathVariable("password") String pwd) throws NoResultException {
		return service.userAuth(email, pwd);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) throws EntityAlreadyExistException {
		return service.create(user);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id, @RequestBody User user) throws EntityNotFoundException {
		return service.update(id, user);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete( @PathVariable("id") String id) {
		service.delete(id);
	}
}
