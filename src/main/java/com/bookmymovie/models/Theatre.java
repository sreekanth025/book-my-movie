package com.bookmymovie.models;

import java.sql.Timestamp;
import java.util.Arrays;

public class Theatre {
	
	private String theatre_id;
	private String screen_id;
	private String name;
	private String street;
	private String city;
	private Integer price;
	private Timestamp[] show_time;
	
	
	public Theatre() {

	}
	
	public Theatre(String theatre_id, String screen_id, String name, String street, String city, Integer price,
			Timestamp[] show_time) {
		this.theatre_id = theatre_id;
		this.screen_id = screen_id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.price = price;
		this.show_time = show_time;
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
	public Timestamp[] getShow_time() {
		return show_time;
	}
	public void setShow_time(Timestamp[] show_time) {
		this.show_time = show_time;
	}
	
	
	
	@Override
	public String toString() {
		return "Theatre [theatre_id=" + theatre_id + ", screen_id=" + screen_id + ", name=" + name + ", street="
				+ street + ", city=" + city + ", price=" + price + ", show_time=" + Arrays.toString(show_time) + "]";
	}
	
}
