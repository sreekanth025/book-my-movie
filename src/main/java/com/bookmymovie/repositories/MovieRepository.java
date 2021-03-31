package com.bookmymovie.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

//	List<> getTopMovies() {
//		// get { title, rating, genre, poster_id } of top 4 movies
//	}
	
	
//	List<String> getLangugaes(String movie) {
//		// get available languages for a movie
//	}
	
}
