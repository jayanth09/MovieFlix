package io.egen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries (
			@NamedQuery(name="Movie.findByTitle", query="Select m from Movie m where m.Title= :pTitle")
		)
public class Movie {
	
	@Id
	@GenericGenerator(strategy="uuid2", name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String id;
	
	@Column(unique=true)
	private String Title;
	private String Year;
	private String Rated;
	
	@JsonFormat(pattern="dd MMM yyyy")
	private Date Released;
	
	private String Runtime;
	private String Genre;
	private String Director;
	private String Writer;
	private String Plot;
	private String Actors;
	private String Language;
	private String Country;
	private String Awards;
	private String Poster;
	private String Metascore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String Type;
	
}
