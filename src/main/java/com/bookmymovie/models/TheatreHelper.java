package com.bookmymovie.models;

public class TheatreHelper {

	private String theatre_id;
	private String screen_id;
	private String name;
	private String street;
	private String city;
	private Integer price;
	
	
	public TheatreHelper() {

	}
	
	public TheatreHelper(String theatre_id, String screen_id, String name, String street, String city, Integer price) {
		this.theatre_id = theatre_id;
		this.screen_id = screen_id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.price = price;
	}
	
	
	public String getTheatre_id() {
		return theatre_id;
	}
	public void setTheatre_id(String theatre_id) {
		this.theatre_id = theatre_id;
	}
	public String getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(String screen_id) {
		this.screen_id = screen_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Theatre [theatre_id=" + theatre_id + ", screen_id=" + screen_id + ", name=" + name + ", street="
				+ street + ", city=" + city + ", price=" + price + "]";
	}
	
}
