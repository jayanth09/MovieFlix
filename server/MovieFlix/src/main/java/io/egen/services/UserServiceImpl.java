package io.egen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.User;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;
import io.egen.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) throws EntityNotFoundException{
		 User user = repository.findOne(id);
		 if(user == null) {
			 throw new EntityNotFoundException();
		 }
		 else {
				return user;
		 }
	}

	@Override
	public User create(User user) throws EntityAlreadyExistException{
			User existing = repository.findbyEmail(user.getEmail());
			if(existing != null) {
				throw new EntityAlreadyExistException();
			}
			else {
				return repository.create(user);
			}
		
	}

	@Override
	public User update(String id, User user) throws EntityNotFoundException {
		User existing = repository.findOne(id);
		if(existing ==null) {
			throw new EntityNotFoundException();
		}
		else {
			return repository.update(user);
		}
	}

	@Override
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing == null) {
				//
		}
		repository.delete(existing	);
	}

	@Override
	public User userAuth(String email, String pwd) {
		User existing = repository.userAuth(email, pwd);
		if(existing == null) {
			return null;
		}
		else {
			return existing;
		}
	}
		
	

	
}
