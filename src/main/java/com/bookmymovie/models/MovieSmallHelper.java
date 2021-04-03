package com.bookmymovie.models;

public class MovieSmallHelper {
	
	private String movie_id;
	private String title;
	private double rating;
	private String poster_link;
	
	
	public MovieSmallHelper() {

	}
	
	public MovieSmallHelper(String movie_id, String title, double rating, String poster_link) {
		this.movie_id = movie_id;
		this.title = title;
		this.rating = rating;
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
	public String getPoster_link() {
		return poster_link;
	}
	public void setPoster_link(String poster_link) {
		this.poster_link = poster_link;
	}

	
	@Override
	public String toString() {
		return "MovieSmallHelper [movie_id=" + movie_id + ", title=" + title + ", rating=" + rating + ", poster_link="
				+ poster_link + "]";
	}
	
}
