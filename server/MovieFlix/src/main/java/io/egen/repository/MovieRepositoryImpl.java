package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.entity.Movie;

@Repository
public class MovieRepositoryImpl  implements MovieRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m ORDER BY m.Title ASC", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query= em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movie = query.getResultList();
		if(movie!= null && movie.size() ==1) {
			return movie.get(0);
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<Movie> findByType(String Type) {
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m where m.Type= :pType", Movie.class);
		query.setParameter("pType", Type);
		return query.getResultList();
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		em.merge(movie);
		return movie;
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	@Override
	public List<Movie> sortByImdbRating() {
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m ORDER BY m.imdbRating DESC", Movie.class);
		List<Movie> movies = query.getResultList();
		if(movies.isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			return query.getResultList();
		}
		
	}

	@Override
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query = em.createQuery("Select m from Movie m ORDER BY m.Year DESC", Movie.class);
		List<Movie> movies = query.getResultList();
		if(movies.isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			return query.getResultList();
		}
	}
}
