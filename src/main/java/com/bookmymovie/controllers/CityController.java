package com.bookmymovie.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.models.MovieSmall;
import com.bookmymovie.models.Theatre;
import com.bookmymovie.services.CityService;

@RestController
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	
	// Get all cities
	@RequestMapping("/api/cities")
	public List<String> getAllcities() {
		return cityService.getAllCities();
	}
	
	
	
	// Get all movies in a city
	@RequestMapping("/api/cities/{city}/movies")
	public List<MovieSmall> getMoviesInCity(@PathVariable String city) {
		return cityService.getMoviesInCity(city);
	}
	
	
	
	// Get all theaters in a city for a given movie
	@RequestMapping(value="/api/cities/{city}/movies/{movie_id}")
	public List<Theatre> getAllTheatres(@PathVariable String city, 
				@PathVariable String movie_id, @RequestParam Map<String, String> payload){
		
		String show_date = payload.get("show_date");
		String language = payload.get("language");
		
//		System.out.println(show_date);
//		System.out.println(language);
		
		return cityService.getAllTheatres(city, movie_id, show_date, language);
	}
	
}
