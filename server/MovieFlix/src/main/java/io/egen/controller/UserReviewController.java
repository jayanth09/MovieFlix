package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.UserReview;
import io.egen.services.UserReviewService;

@RestController
@RequestMapping(value="/review")
public class UserReviewController {
		
	@Autowired
	private UserReviewService service;
	
	@RequestMapping(value="/findById/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserReview> findReviewById(@PathVariable("id") String id) {
		return service.findReviewById(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReview findOne(@PathVariable("id") String id)  {
		return service.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReview create(@RequestBody UserReview review) {
		return service.create(review);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReview update(@PathVariable("id") String id, @RequestBody UserReview review) {
		return service.update(id, review);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete( @PathVariable("id") UserReview review) {
		service.delete(review);
	}
}
