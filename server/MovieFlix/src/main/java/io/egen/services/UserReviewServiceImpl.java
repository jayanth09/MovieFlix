package io.egen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.UserReview;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;
import io.egen.repository.UserReviewRepository;

@Service
@Transactional
public class UserReviewServiceImpl implements UserReviewService {

	@Autowired
	private UserReviewRepository repository;
	
	
	@Override
	public List<UserReview> findReviewById(String id) throws EntityNotFoundException {
		
		List<UserReview> reviews = repository.findReviewById(id);
		if(reviews !=null) {
			return reviews;
		}
		else {
			throw new EntityNotFoundException();		
		}
	}
	
	@Override
	public UserReview findOne(String id) throws EntityNotFoundException {
		UserReview review = repository.findOne(id);
		if(review == null) {
			throw new EntityNotFoundException();
		}
		else  {
			return review;
		}
	}

	@Override
	public UserReview create(UserReview review) throws EntityAlreadyExistException{
		UserReview existing = repository.create(review);
		if(existing == null) {
			throw new EntityAlreadyExistException();
		}
		else {
			return existing;
		}	
	}
	
	@Override
	public UserReview update(String id, UserReview review) throws EntityNotFoundException {
		UserReview existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException();
		}
		else {
			return repository.update(id, review);
		}
	}

	@Override
	public void delete(UserReview review) {
		repository.delete(review);
	}
}
