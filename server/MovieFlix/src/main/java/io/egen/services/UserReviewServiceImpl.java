package io.egen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.UserReview;
import io.egen.repository.UserReviewRepository;

@Service
@Transactional
public class UserReviewServiceImpl implements UserReviewService {

	@Autowired
	private UserReviewRepository repository;
	
	
	@Override
	public List<UserReview> findReviewById(String id)  {
		
		List<UserReview> reviews = repository.findReviewById(id);
		if(reviews !=null) {
			return reviews;
		}
		else {
			return null;		
		}
	}
	
	@Override
	public UserReview findOne(String id) {
		UserReview review = repository.findOne(id);
		if(review == null) {
			return null;
		}
		else  {
			return review;
		}
	}

	@Override
	public UserReview create(UserReview review) {
			//System.out.println(review.getMovie().getId());
			return repository.create(review);
	}
	
	@Override
	public UserReview update(String id, UserReview review) {
		UserReview existing = repository.findOne(id);
		if(existing == null) {
			return null;
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
