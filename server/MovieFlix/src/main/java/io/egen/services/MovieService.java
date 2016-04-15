package io.egen.services;

import java.util.List;

import org.springframework.stereotype.Component;

import io.egen.entity.Movie;
@Component
public interface MovieService {
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie movie);
	public Movie update(String id, Movie movie);
	public Movie delete(Movie movie);
}
