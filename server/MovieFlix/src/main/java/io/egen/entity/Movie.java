package io.egen.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/*@Data
@Entity
@Table*/
public class Movie {
	
	@Id
	@GenericGenerator(strategy="uuid2", name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String id;
	
	private String title;
	private int year;
	private String rated;
	private Date released;
	private String runtime;
	private List<String> genre;
	private String director;
	private List<String> writer;
	private String plot;
	private String actor;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private int metascore;
	private double imdbRating;
	private long imdbVotes;
	private String imdbId;
	private String type;;
	
}
