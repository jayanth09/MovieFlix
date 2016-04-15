package io.egen.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.egen.entity.Movie;

@Repository
public class MovieRepositoryImpl  implements MovieRepository{

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
	public Movie delete(String id) {
		return null;
	}

}
