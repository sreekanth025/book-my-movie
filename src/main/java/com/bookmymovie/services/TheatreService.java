package com.bookmymovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmymovie.models.Ticket;
import com.bookmymovie.repositories.TheatreRepository;

@Service
public class TheatreService {
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	public List<String> getBookedSeats(String theatre_id, String screen_id, String show_date, String show_time) {
		return theatreRepository.getBookedSeats(theatre_id, screen_id, show_date, show_time);
	}
	
	
	public Ticket bookTicket(String theatre_id, String screen_id, String show_date, String show_time, List<String> seats, String email) {
		
		//handle concurrency
		
		
		Integer ticket_id = theatreRepository.getTicketid();		
		String t_id = "TCKT00" + ticket_id.toString();		
		
		theatreRepository.insertTicket(email, t_id);
		theatreRepository.bookSeats(theatre_id, screen_id, show_date, show_time, seats, t_id);
		
		return theatreRepository.getTicket(t_id);
		
	}
}
