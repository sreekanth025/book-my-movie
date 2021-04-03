package com.bookmymovie.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.models.Crew;
import com.bookmymovie.models.Movie;
import com.bookmymovie.models.MovieHelper;
import com.bookmymovie.models.MovieSmall;
import com.bookmymovie.models.MovieSmallHelper;
import com.bookmymovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	// Get details of top movies
	public List<MovieSmall> getTopMovies() {
		
		List<MovieSmallHelper> movies_without_lang_genre = movieRepository.getTopMovies();
		List<MovieSmall> top_movies = new ArrayList<MovieSmall>();
		
		for(MovieSmallHelper m: movies_without_lang_genre) {
			
			List<String> languages = movieRepository.getLangugaes(m.getMovie_id());
			List<String> genres = movieRepository.getGenres(m.getMovie_id());
			
			top_movies.add(new MovieSmall(
					m.getMovie_id(), 
					m.getTitle(), 
					m.getRating(),
					languages.toArray(new String[languages.size()]), 
					genres.toArray(new String[languages.size()]),
					m.getPoster_link()
				));
		}
		
		return top_movies;
	}
	
	
	
	// Get all the details of a movie
	public Movie getMovieDetails(String movie_id) {
		
		MovieHelper m = movieRepository.getMovie(movie_id);
		
		List<String> languages = movieRepository.getLangugaes(movie_id);
		List<String> genres = movieRepository.getGenres(movie_id);
		List<Crew> crew = movieRepository.getCrew(movie_id);
		
		Movie movie = new Movie(
					m.getMovie_id(),
					m.getTitle(),
					m.getRating(),
					m.getCertification(),
					m.getDuration(),
					m.getRelease_date(),
					m.getAbout(),
					m.getPoster_link(),
					languages.toArray(new String[languages.size()]),
					genres.toArray(new String[genres.size()]),
					crew.toArray(new Crew[crew.size()])
				);
		
		return movie;
	}
	
}
