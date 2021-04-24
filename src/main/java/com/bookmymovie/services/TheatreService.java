package com.bookmymovie.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import com.bookmymovie.models.Ticket;
import com.bookmymovie.repositories.TheatreRepository;

@Service
public class TheatreService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired
	private EmailService emailService;
	
	public List<String> getBookedSeats(String theatre_id, String screen_id, String show_date, String show_time) {
		return theatreRepository.getBookedSeats(theatre_id, screen_id, show_date, show_time);
	}
	
	
	public Ticket bookTicket(String theatre_id, 
							String screen_id, 
							String show_date, 
							String show_time, 
							List<String> seats, 
							String email) throws SQLException {
		
		//handle concurrency
		Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		stmt.execute("LOCK TABLE seat IN EXCLUSIVE MODE");
		
		
		List<String> bookedSeats = theatreRepository.getBookedSeats(theatre_id, screen_id, show_date, show_time);
		
		// Check if all the requested seats are available
		Boolean available = true;
		for(String seat_id: seats) {
			if(bookedSeats.contains(seat_id)) {
				available = false;
				break;
			}
		}
		
		if(!available) {
			Ticket t = new Ticket("INVALID", email, null);
			conn.setAutoCommit(true);
			conn.commit();
			return t;
		}

		
		Integer ticket_id = theatreRepository.getTicketid();		
		String t_id = "TCKT00" + ticket_id.toString();		
		
		theatreRepository.insertTicket(email, t_id);
//		theatreRepository.bookSeats(theatre_id, screen_id, show_date, show_time, seats, t_id);
		theatreRepository.BookSeatsWithConnection(conn, theatre_id, screen_id, show_date, show_time, bookedSeats, t_id);
		
		conn.setAutoCommit(true);
		conn.commit(); // Release the lock on seat table
		
		emailService.sendEmail(theatre_id, screen_id, show_date, show_time, seats, email, t_id);
		
		return theatreRepository.getTicket(t_id);
		
	}
}
