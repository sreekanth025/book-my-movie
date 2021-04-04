package com.bookmymovie.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.models.MovieSmall;
import com.bookmymovie.models.MovieSmallHelper;
import com.bookmymovie.models.Theatre;
import com.bookmymovie.models.TheatreHelper;
import com.bookmymovie.repositories.MovieRepository;
import com.bookmymovie.repositories.TheatreRepository;

@Service
public class CityService {
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	
	// Get list of all cities
	public List<String> getAllCities() {
		return theatreRepository.getAllCities();
	}
	
	
	
	// Get details of all movies in a city
	public List<MovieSmall> getMoviesInCity(String city) {
		
		List<MovieSmallHelper> movies_without_lang_genre = movieRepository.getMoviesInCity(city);
		List<MovieSmall> movies_in_city = new ArrayList<MovieSmall>();
		
		for(MovieSmallHelper m: movies_without_lang_genre) {
			
			List<String> languages = movieRepository.getLangugaes(m.getMovie_id());
			List<String> genres = movieRepository.getGenres(m.getMovie_id());
			
			movies_in_city.add(new MovieSmall(
					m.getMovie_id(), 
					m.getTitle(), 
					m.getRating(),
					languages.toArray(new String[languages.size()]), 
					genres.toArray(new String[languages.size()]),
					m.getPoster_link()
				));
			
		}
		
		return movies_in_city;
	}
	
	
	
	// Get all available theaters for a given city, movie, date and time
	public List<Theatre> getAllTheatres(String city, String movie_id, String show_date, String language){
		// To be done
		List<TheatreHelper> theatres_without_showtimes = theatreRepository.getAllTheatres(city, movie_id, show_date, language);
		List<Theatre> theatres = new ArrayList<Theatre>();
		
		for(TheatreHelper t: theatres_without_showtimes) {
			
			List<Timestamp> show_times = theatreRepository.getShowtimes(movie_id, t.getTheatre_id(), t.getScreen_id(), show_date, language);
			
			theatres.add(new Theatre(
						t.getTheatre_id(),
						t.getScreen_id(),
						t.getName(),
						t.getStreet(),
						t.getCity(),
						t.getPrice(),
						show_times.toArray(new Timestamp[show_times.size()])
					));
		}
		
		return theatres;
	}
	
}
