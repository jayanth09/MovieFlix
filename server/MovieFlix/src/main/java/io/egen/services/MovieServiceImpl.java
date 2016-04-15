package io.egen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreayExistException;
import io.egen.exception.MovieNotFoundException;
import io.egen.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl  implements MovieService{

	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<Movie> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) throws MovieNotFoundException {
		Movie movie = repository.findOne(id);
		if(movie == null) {
			throw new MovieNotFoundException();
		}
		else {
			return movie;
		}
	}

	@Override
	public Movie create(Movie movie) throws MovieAlreayExistException {
		Movie existing = repository.findByTitle(movie.getTitle());
		if(existing != null) {
			throw new MovieAlreayExistException();
		}
		else {
			return repository.create(movie);
		}
	}

	@Override
	public Movie update(String id, Movie movie) throws MovieNotFoundException{
		Movie existing = repository.findOne(id);
		if(existing == null) {
			throw new MovieNotFoundException();
		}
		else {
			return repository.update(movie);
		}
	}

	@Override
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if(existing != null) {
		 repository.delete(existing);
		}
	}

}
