package io.egen.repository;

import java.util.List;

import io.egen.entity.UserReview;

public interface UserReviewRepository {
	public List<UserReview> findReviewById(String id);
	public UserReview create(UserReview review);
	public UserReview findOne(String id);
	public UserReview update(String id, UserReview review);
	public void delete(UserReview review);
}
