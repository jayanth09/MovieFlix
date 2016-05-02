package io.egen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Movie;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;
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
	public Movie findOne(String id) throws EntityNotFoundException {
		Movie movie = repository.findOne(id);
		if(movie == null) {
			throw new EntityNotFoundException();
		}
		else  {
			return movie;
		}
	}
	
	@Override
	public Movie findByTitle(String Title) throws EntityNotFoundException {
		Movie existing = repository.findByTitle(Title);
		if(existing !=null) {
			return existing;
		}
		else {
				throw new EntityNotFoundException();
		}
	}
	
	@Override
	public List<Movie> findByType(String Type) throws EntityNotFoundException {
		List<Movie> movie = repository.findByType(Type);
		if(movie.isEmpty()) {
			throw new EntityNotFoundException();
		}
		else {
			return movie;
		}
		
	}


	@Override
	public Movie create(Movie movie) throws EntityAlreadyExistException {
		Movie existing = repository.findByTitle(movie.getTitle());
		if(existing != null) {
			throw new EntityAlreadyExistException();
		}
		else {
			return repository.create(movie);
		}
	}

	@Override
	public Movie update(String id, Movie movie) throws EntityNotFoundException{
		Movie existing = repository.findOne(id);
		if(existing == null) {
			throw new EntityNotFoundException();
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

	@Override
	public List<Movie> sortByImdbRating() {
		return repository.sortByImdbRating();
	}

	@Override
	public List<Movie> sortByYear() {
		return repository.sortByYear();
	}

	@Override
	public List<Movie> getTopRatedMovies() {
		return repository.getTopRatedMovies();
	}

	@Override
	public List<Movie> getTopRatedSeries() {
		return repository.getTopRatedSeries();
	}

	@Override
	public List<Movie> sortByImdbVotes() {
		return repository.sortByImdbVotes();
	}

}
