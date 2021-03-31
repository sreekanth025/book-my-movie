package com.bookmymovie.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

//	public List<String> getAllCities() {
//		
//	}
}
