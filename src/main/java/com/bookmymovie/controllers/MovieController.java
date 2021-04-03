package com.bookmymovie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.models.Movie;
import com.bookmymovie.models.MovieSmall;
import com.bookmymovie.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	
	// Get details of top movies
	@RequestMapping("/api/movies/topMovies")
	public List<MovieSmall> getTopMovies() {
		return movieService.getTopMovies();
	}
	
	
	// Get all details of a movie
	@RequestMapping("/api/movies/{movie_id}")
	public Movie getMovieDetails(@PathVariable String movie_id) {
		return movieService.getMovieDetails(movie_id);
	}
	
}
