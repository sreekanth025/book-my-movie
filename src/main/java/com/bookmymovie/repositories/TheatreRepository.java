package com.bookmymovie.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookmymovie.models.TheatreHelper;
import com.bookmymovie.models.Ticket;

@Repository
public class TheatreRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// Get list of all cities
	public List<String> getAllCities() {
		
		String query_string = "SELECT DISTINCT city FROM theatre";
		
		List<String> cities = jdbcTemplate.query(query_string, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return cities;
	}
	
	
	
	public List<TheatreHelper> getAllTheatres(String city, String movie_id, String show_date, String language) {
		
		String query_string = "SELECT DISTINCT  theatre_id, screen_id, name, street, city, price "
							+ "FROM runs_on NATURAL JOIN theatre "
							+ "WHERE city = '" + city + "' AND movie_id = '" + movie_id + "' "
							+ "AND language = '" + language + "' AND TRUNC(show_time) = '" + show_date + "'";
		
		List<TheatreHelper> theatres = jdbcTemplate.query(query_string, 
					BeanPropertyRowMapper.newInstance(TheatreHelper.class));
		
		return theatres;
		
	}
	
	public List<Timestamp> getShowtimes(String movie_id, String theatre_id, String screen_id, String show_date, String language) {
		
		String query_string = "SELECT show_time FROM runs_on "
							+ "WHERE movie_id = '" + movie_id   + "' "
							+ "AND theatre_id = '" + theatre_id + "' " 
							+ "AND screen_id  = '" + screen_id  + "' " 
							+ "AND TRUNC(show_time) = '" + show_date  + "' " 
							+ "AND language   = '" + language   + "'";
		
		List<Timestamp> show_times = jdbcTemplate.query(query_string, new RowMapper<Timestamp>() {
			public Timestamp mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getTimestamp(1);
			}
		});
		
		return show_times;
	
	}
	
	public List<String> getBookedSeats(String theatre_id, String screen_id, String show_date, String show_time) {
		
		String query_string = "SELECT seat_id FROM seat WHERE theatre_id = '" + theatre_id + "' "
							+ "AND screen_id = '" + screen_id + "' "
							+ "AND show_date = TO_DATE('" + show_date + "', 'YYYY-MM-DD') "
							+ "AND show_time = TO_TIMESTAMP('" + show_time + "', 'YYYY-MM-DD:HH24:MI:SS')";
		
		List<String> seats = jdbcTemplate.query(query_string, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getString(1);
			}
		});
		
		return seats;
	}
	
	public Integer getTicketid() {
		
		String ticketid_query = "SELECT TICKET_SEQUENCE.NEXTVAL FROM dual";
		
		List<Integer> t_id = jdbcTemplate.query(ticketid_query, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getInt(1);
			}
		});
		
		return t_id.get(0);
	}
	
	public void bookSeats(String theatre_id, String screen_id, String show_date, String show_time, List<String> seats, String ticket_id) {
		
		
		for(String seat: seats) {
			
			String sql = "INSERT INTO seat VALUES ('" + theatre_id + "', '"
					+ screen_id + "','" + seat + "' , TO_TIMESTAMP('" + 
				    show_time + "', 'YYYY-MM-DD:HH24:MI:SS'), DATE '"+ show_date + "', '"+ ticket_id + "')";
			
//			System.out.println(sql);
			int n = jdbcTemplate.update(sql);			
//			System.out.println(n);
		}
		
	}
	
	public void insertTicket(String email,String ticket_id) {
		
		String sql = "INSERT INTO ticket VALUES ('" + ticket_id + "','" + email + "', SYSTIMESTAMP )";
		int n = jdbcTemplate.update(sql);
		
//		System.out.println(n);
	}
	
	public Ticket getTicket(String ticket_id) {
		
		 String sql = "SELECT * FROM ticket where ticket_id = '" + ticket_id + "'";
		 
		 List<Ticket> tickets = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
		 return tickets.get(0);
	}
}
