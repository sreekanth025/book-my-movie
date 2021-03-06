package com.bookmymovie.models;

import java.sql.Date;
import java.util.Arrays;

public class Movie {
	
	private String movie_id;
	private String title;
	private Double rating;
	private String certification;
	private Integer duration;
	private Date release_date;
	private String about;
	private String poster_link;
	
	private String[] languages;
	private String[] genres;
	private Crew[] crew;
	
	
	public Movie() {

	}
	
	
	public Movie(String movie_id, String title, Double rating, String certification, Integer duration,
			Date release_date, String about, String poster_link, String[] languages, String[] genres, Crew[] crew) {
		this.movie_id = movie_id;
		this.title = title;
		this.rating = rating;
		this.certification = certification;
		this.duration = duration;
		this.release_date = release_date;
		this.about = about;
		this.poster_link = poster_link;
		this.languages = languages;
		this.genres = genres;
		this.crew = crew;
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
	public Crew[] getCrew() {
		return crew;
	}
	public void setCrew(Crew[] crew) {
		this.crew = crew;
	}


	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", title=" + title + ", rating=" + rating + ", certification="
				+ certification + ", duration=" + duration + ", release_date=" + release_date + ", about=" + about
				+ ", poster_link=" + poster_link + ", languages=" + Arrays.toString(languages) + ", genres="
				+ Arrays.toString(genres) + ", crew=" + Arrays.toString(crew) + "]";
	}

}

// generate constructors, getters and setters after deciding datatypes