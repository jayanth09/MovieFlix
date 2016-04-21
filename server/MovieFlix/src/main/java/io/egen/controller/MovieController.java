package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Movie;
import io.egen.exception.EntityAlreadyExistException;
import io.egen.exception.EntityNotFoundException;
import io.egen.services.MovieService;

@RestController
@RequestMapping(value="/movies")
public class MovieController {
	
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String id)  throws EntityNotFoundException {
		return service.findOne(id);
	}
	
	@RequestMapping(value="/title/{Title}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByTitle(@PathVariable("Title") String Title)  throws EntityNotFoundException{
		return service.findByTitle(Title);
	} 
	@RequestMapping(value="/type/{Type}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByType(@PathVariable("Type") String Type)  throws EntityNotFoundException{
		return service.findByType(Type);
	} 
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create( @RequestBody Movie movie) throws EntityAlreadyExistException{
		return service.create(movie);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie) throws EntityNotFoundException {
		return service.update(id, movie);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@RequestMapping(value="/imdbRating", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByImdbRating() {
		return service.sortByImdbRating();
	}
	
	@RequestMapping(value="/year", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	
	@RequestMapping(value="/topMovies", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getTopRatedMovies() {
		return service.getTopRatedMovies();
	}
	
	@RequestMapping(value="/topSeries", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getTopRatedSeries() {
		return service.getTopRatedSeries();
	}
	
}
