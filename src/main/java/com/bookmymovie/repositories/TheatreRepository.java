package com.bookmymovie.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// Get list of all cities
	public List<String> getAllCities() {
		
		String query_string = "SELECT DISTINCT city FROM theatre";
		
		List<String> cities = jdbcTemplate.query(query_string, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return cities;
	}
	
}
