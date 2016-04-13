package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Movie;
import io.egen.services.MovieServices;

@RestController
@RequestMapping(value="/movies")
public class MovieController {
	
	@Autowired
	private MovieServices service;
	
	
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	public Movie findOne(String id) {
		return service.findOne(id);
	}
	
	public Movie create(Movie movie) {
		return service.create(movie);
	}
	
	public Movie update(String id, Movie movie) {
		return service.update(id, movie);
	}
	
	public Movie delete(String id) {
		return service.delete(id);
	}
}
