package com.bookmymovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bookmymovie.models.TheatreHelper;
import com.bookmymovie.repositories.TheatreRepository;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	
	public void sendEmail(String theatre_id, 
						String screen_id, 
						String show_date, 
						String show_time, 
						List<String> seats, 
						String email,
						String ticket_id) {
		
		
		String movieName = theatreRepository.getMovieName(theatre_id, screen_id, show_time);
		TheatreHelper theatre = theatreRepository.getTheatreDetails(theatre_id);
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		String seatsString = String.join(", ", seats);
		
		String body = "Payment done Successfully !\n\n"
					+ "Booking Summary: \n"
					+ "Your Ticket ID : " + ticket_id + "\n"
					+ "Movie Name: " + movieName + "\n"
					+ "Theatre Name: " + theatre.getName() + "\n"
					+ "Screen ID : " + screen_id + "\n"
					+ "Address : " + theatre.getStreet() + ", " + theatre.getCity() + "\n"
					+ "Seats : " + seatsString + "\n"
					+ "Date and Time : " + show_time + "\n\n"
					+ "Enjoy your show :)\n"
					+ "From the team of Book My Movie";
		
//		System.out.println(body);
		
		message.setFrom("BookMyMovie");
        message.setTo(email);
        message.setCc("bookmymovie95@gmail.com");
        message.setText(body);
        message.setSubject("Book My Movie: Tickets Booked");
        
        mailSender.send(message);
	}
}
