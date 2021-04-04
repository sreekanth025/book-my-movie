package com.bookmymovie.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookmymovie.models.TheatreHelper;

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
	
	
	
	public List<TheatreHelper> getAllTheatres(String city, String movie_id, String show_date, String language) {
		
		String query_string = "SELECT DISTINCT  theatre_id, screen_id, name, street, city, price "
							+ "FROM runs_on NATURAL JOIN theatre "
							+ "WHERE city = '" + city + "' AND movie_id = '" + movie_id + "' "
							+ "AND language = '" + language + "' AND TRUNC(show_time) = '" + show_date + "'";
		
		List<TheatreHelper> theatres = jdbcTemplate.query(query_string, 
					BeanPropertyRowMapper.newInstance(TheatreHelper.class));
		
		return theatres;
		
	}
	
	public List<Timestamp> getShowtimes(String movie_id, String theatre_id, String screen_id, String show_date, String language) {
		
		String query_string = "SELECT show_time FROM runs_on "
							+ "WHERE movie_id = '" + movie_id   + "' "
							+ "AND theatre_id = '" + theatre_id + "' " 
							+ "AND screen_id  = '" + screen_id  + "' " 
							+ "AND TRUNC(show_time) = '" + show_date  + "' " 
							+ "AND language   = '" + language   + "'";
		
		List<Timestamp> show_times = jdbcTemplate.query(query_string, new RowMapper<Timestamp>() {
			public Timestamp mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getTimestamp(1);
			}
		});
		
		return show_times;
	
	}
}
