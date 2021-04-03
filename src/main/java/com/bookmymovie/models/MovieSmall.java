package com.bookmymovie.models;

import java.util.Arrays;

public class MovieSmall {
	
	private String movie_id;
	private String title;
	private double rating;
	private String[] languages;
	private String[] genres;
	private String poster_link;
	
	
	public MovieSmall() {

	}
	
	public MovieSmall(String movie_id, String title, double rating, String[] languages, String[] genres,
			String poster_link) {
		this.movie_id = movie_id;
		this.title = title;
		this.rating = rating;
		this.languages = languages;
		this.genres = genres;
		this.poster_link = poster_link;
	}
	
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	public String getPoster_link() {
		return poster_link;
	}
	public void setPoster_link(String poster_link) {
		this.poster_link = poster_link;
	}

	
	@Override
	public String toString() {
		return "MovieSmall [movie_id=" + movie_id + ", title=" + title + ", rating=" + rating + ", languages="
				+ Arrays.toString(languages) + ", genres=" + Arrays.toString(genres) + ", poster_link=" + poster_link
				+ "]";
	}
	
}
