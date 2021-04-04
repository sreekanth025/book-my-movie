package com.bookmymovie.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.services.TheatreService;

@RestController
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;

	@RequestMapping("/api/theatres/{theatre_id}/{screen_id}/")
	public List<String> getBookedSeats(@PathVariable String theatre_id, @PathVariable String screen_id, 
			@RequestBody Map<String, String> payload) {
		
		String show_date = payload.get("show_date");
		String show_time = payload.get("show_time");
		
		return theatreService.getBookedSeats(theatre_id, screen_id, show_date, show_time);
	}
}
