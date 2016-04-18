package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.entity.UserReview;

@Repository
public class UserReviewRepositoryImpl implements UserReviewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserReview> findReviewById(String id) {
		TypedQuery<UserReview> query = em.createQuery("Select r from UserReview r where r.movie.id=:Id", UserReview.class);
		query.setParameter("Id", id);
		List<UserReview> reviews = query.getResultList();
		if(reviews!= null && reviews.size() >=1) {
			return reviews;
		}
		else {
			return null;
		}
	}
	
	@Override
	public UserReview findOne(String id) {
		return em.find(UserReview.class, id);
	}

	@Override
	public UserReview create(UserReview review) {
		
		em.persist(review);
		return review;
	}

	@Override
	public UserReview update(String id, UserReview review) {
		em.merge(review);
		return review;
	}

	public void delete(UserReview review) {
		em.remove(review);
	}

	

}
