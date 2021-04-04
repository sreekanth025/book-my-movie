package com.bookmymovie.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookmymovie.models.Ticket;
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
	
	@RequestMapping(method=RequestMethod.POST,value="/api/booking")
	public Ticket bookTicket(@RequestBody Map<String,Object> payload) {
		
		String theatre_id = (String) payload.get("theatre_id");
		String screen_id  = (String) payload.get("screen_id");
		String show_date  = (String) payload.get("show_date");
		String show_time  = (String) payload.get("show_time");
		
		@SuppressWarnings("unchecked")
		List<String> seats= (List<String>) payload.get("seats");
		String email      = (String) payload.get("email");
		
//		System.out.println(theatre_id);
//		System.out.println(screen_id);
//		System.out.println(show_date);
//		System.out.println(show_time);
//		System.out.println(seats);
//		System.out.println(email);
		
		return theatreService.bookTicket(theatre_id, screen_id, show_date, show_time, seats, email);
	}
}
