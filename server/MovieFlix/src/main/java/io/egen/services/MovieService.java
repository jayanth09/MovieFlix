package io.egen.services;

import java.util.List;

import org.springframework.stereotype.Component;

import io.egen.entity.Movie;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;
@Component
public interface MovieService {
	public List<Movie> findAll();
	public Movie findByTitle(String Title) throws EntityNotFoundException;
	public List< Movie> findByType(String Type) throws EntityNotFoundException;
	public Movie findOne(String id) throws EntityNotFoundException;
	public Movie create(Movie movie) throws EntityAlreadyExistException;
	public Movie update(String id, Movie movie) throws EntityNotFoundException;
	public void delete(String id);
}
