package com.bookmymovie.models;

import java.sql.Timestamp;

public class Ticket {

	private String ticket_id;
	private String email;
	private Timestamp booking_time;
	
	public Ticket() {
		
	}
	
	public Ticket(String ticket_id, String email, Timestamp booking_time) {
		super();
		this.ticket_id = ticket_id;
		this.email = email;
		this.booking_time = booking_time;
	}
	
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getBooking_time() {
		return booking_time;
	}
	public void setBooking_time(Timestamp booking_time) {
		this.booking_time = booking_time;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", email=" + email + ", booking_time=" + booking_time + "]";
	}
	
}
