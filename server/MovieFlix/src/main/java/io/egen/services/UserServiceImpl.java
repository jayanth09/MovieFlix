package io.egen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.User;
import io.egen.exception.UserAlreadyExistException;
import io.egen.exception.UserNotFoundException;
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
	public User findOne(String id) throws UserNotFoundException{
		 User user = repository.findOne(id);
		 if(user == null) {
			 throw new UserNotFoundException();
		 }
		 else {
				return user;
		 }
	}

	@Override
	public User create(User user) throws UserAlreadyExistException{
			User existing = repository.findbyEmail(user.getEmail());
			if(existing != null) {
				throw new UserAlreadyExistException();
			}
			else {
				return user;
			}
		
	}

	@Override
	public User update(User user) {
		User existing = repository.findOne(user.getId());
		if(existing ==null) {
			return null;
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
		
	

	
}
