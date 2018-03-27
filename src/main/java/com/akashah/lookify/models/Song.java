package com.akashah.lookify.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column
	@Size(min = 2)
	String title;
	
	@Column
	@Size(min = 2)
	String artist;
	
	@Column
	int rating;
	
	Song() {
		
	}
	
	Song(String title, String Artist, int rating){
		this.title = title;
		this.artist = Artist;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	

}
