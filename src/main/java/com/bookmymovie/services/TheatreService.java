package com.bookmymovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.repositories.TheatreRepository;

@Service
public class TheatreService {
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	public List<String> getBookedSeats(String theatre_id, String screen_id, String show_date, String show_time) {
		return theatreRepository.getBookedSeats(theatre_id, screen_id, show_date, show_time);
	}
}
