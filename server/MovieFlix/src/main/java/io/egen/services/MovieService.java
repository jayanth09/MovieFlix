package io.egen.services;

import java.util.List;

import org.springframework.stereotype.Component;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreayExistException;
import io.egen.exception.MovieNotFoundException;
@Component
public interface MovieService {
	public List<Movie> findAll();
	public Movie findOne(String id) throws MovieNotFoundException;
	public Movie create(Movie movie) throws MovieAlreayExistException;
	public Movie update(String id, Movie movie) throws MovieNotFoundException;
	public void delete(String id);
}
