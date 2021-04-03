package com.bookmymovie.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookmymovie.models.Crew;
import com.bookmymovie.models.MovieHelper;
import com.bookmymovie.models.MovieSmallHelper;

@Repository
public class MovieRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// Get the details of top 4 movies
	public List<MovieSmallHelper> getTopMovies() {
		
		String query_string = "SELECT * FROM ("
							+ "SELECT movie_id, title, rating, poster_link FROM movie "
							+ "ORDER BY rating DESC "
							+ ") WHERE ROWNUM <= 4";
		
		List<MovieSmallHelper> movies = jdbcTemplate.query(query_string, 
				BeanPropertyRowMapper.newInstance(MovieSmallHelper.class));
		
		return movies;
	}
	
	
	
	// Get all languages available for a movie
	public List<String> getLangugaes(String movie_id) {
		
		String query_string = "SELECT language FROM languages WHERE movie_id = " + movie_id;
		
		List<String> languages = jdbcTemplate.query(query_string, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return languages;
	}
	
	
	
	// Get all genres of a movie
	public List<String> getGenres(String movie_id) {
			
		String query_string = "SELECT genre FROM genres WHERE movie_id = " + movie_id;
		
		List<String> genres = jdbcTemplate.query(query_string, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return genres;
	}
	
	
	
	//	Get details of all movies in a city
	public List<MovieSmallHelper> getMoviesInCity(String city) {
		
		String query_string = "SELECT DISTINCT  movie_id, title, rating, poster_link "
							+ "FROM movie NATURAL JOIN theatre NATURAL JOIN runs_on "
							+ "WHERE city = " + city;
		
		List<MovieSmallHelper> movies = jdbcTemplate.query(query_string, 
				BeanPropertyRowMapper.newInstance(MovieSmallHelper.class));
		
		return movies;
	}
	
	
	
	//	Get details of crew members in a movie
	public List<Crew> getCrew(String movie_id) {
		
		String query_string = "SELECT * FROM crew WHERE movie_id = " + movie_id;
		
		List<Crew> crew = jdbcTemplate.query(query_string, 
				BeanPropertyRowMapper.newInstance(Crew.class));
		
		return crew;
	}
	
	
	
	// Get details of a movie
	public MovieHelper getMovie(String movie_id) {
		
		String query_string = "SELECT * FROM movie WHERE movie_id = " + movie_id;
		
		// List should contain only one element
		List<MovieHelper> movie_helper_list = jdbcTemplate.query(query_string, 
				BeanPropertyRowMapper.newInstance(MovieHelper.class));
		
		return movie_helper_list.get(0);
	}
}
