package io.egen.repository;

import java.util.List;

import io.egen.entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();
	public Movie findOne(String id);
	public List<Movie> findByType(String Type);
	public Movie findByTitle (String title);
	public Movie create(Movie movie);
	public Movie update( Movie movie);
	public void delete(Movie movie);
	public List<Movie> sortByImdbRating();
	public List<Movie> sortByYear();
	public List<Movie> sortByImdbVotes();
	public List<Movie> getTopRatedMovies();
	public List<Movie> getTopRatedSeries();
}
