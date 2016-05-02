package io.egen.services;

import java.util.List;

import org.springframework.stereotype.Component;

import io.egen.entity.UserReview;

@Component
public interface UserReviewService {
	public List<UserReview> findReviewById(String id);
	public UserReview create(UserReview review) ;
	public UserReview update(String id, UserReview review);
	public UserReview findOne(String id);
	public void delete(UserReview review);

	
}
