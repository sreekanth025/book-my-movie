package com.bookmymovie.models;

import java.sql.Date;

public class MovieHelper {
	
	private String movie_id;
	private String title;
	private Double rating;
	private String certification;
	private Integer duration;
	private Date release_date;
	private String about;
	private String poster_link;
	
	
	public MovieHelper() {

	}
	
	
	public MovieHelper(String movie_id, String title, Double rating, String certification, Integer duration,
			Date release_date, String about, String poster_link) {
		this.movie_id = movie_id;
		this.title = title;
		this.rating = rating;
		this.certification = certification;
		this.duration = duration;
		this.release_date = release_date;
		this.about = about;
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
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getPoster_link() {
		return poster_link;
	}
	public void setPoster_link(String poster_link) {
		this.poster_link = poster_link;
	}
	
	
	@Override
	public String toString() {
		return "MovieHelper [movie_id=" + movie_id + ", title=" + title + ", rating=" + rating + ", certification="
				+ certification + ", duration=" + duration + ", release_date=" + release_date + ", about=" + about
				+ ", poster_link=" + poster_link + "]";
	}

}
