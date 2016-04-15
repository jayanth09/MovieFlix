package io.egen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.entity.Movie;
import io.egen.repository.UserRepository;

@Service
public class MovieServiceImpl  implements MovieService{

	@Autowired
	private UserRepository dao;
	
	@Override
	public List<Movie> findAll() {
		return null;
	}

	@Override
	public Movie findOne(String id) {
		return null;
	}

	@Override
	public Movie create(Movie movie) {
		return null;
	}

	@Override
	public Movie update(String id, Movie movie) {
		return null;
	}

	@Override
	public Movie delete(Movie movie) {
		return null;
	}

}
