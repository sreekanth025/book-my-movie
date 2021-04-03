package com.bookmymovie.models;

public class Crew {

	private String movie_id;
	private String role;
	private String name;
	private String image_link;
	
	
	public Crew() {

	}
	
	public Crew(String movie_id, String role, String name, String image_link) {
		this.movie_id = movie_id;
		this.role = role;
		this.name = name;
		this.image_link = image_link;
	}
	
	
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	
	@Override
	public String toString() {
		return "Crew [movie_id=" + movie_id + ", role=" + role + ", name=" + name + ", image_link=" + image_link + "]";
	}
	
}
