package io.egen.services;

import java.util.List;

import org.springframework.stereotype.Component;

import io.egen.entity.UserReview;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;

@Component
public interface UserReviewService {
	public List<UserReview> findReviewById(String id)throws EntityNotFoundException;
	public UserReview create(UserReview review) throws EntityAlreadyExistException;
	public UserReview update(String id, UserReview review) throws EntityNotFoundException;
	public UserReview findOne(String id) throws EntityNotFoundException;
	public void delete(UserReview review) ;

	
}
