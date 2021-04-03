package com.bookmymovie.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// A class for testing server and connection with database
// Not related to the context of the application

@RestController
public class HelloController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello team!";
	}
	
	
	@RequestMapping("oracleTest")
	public List<String> testOracle() {
		
		String query_string = "SELECT sroll FROM team_members";
		List<String> team = jdbcTemplate.query(query_string, 
			new RowMapper<String>() {
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString(1);
				}
			});
		return team;
	}
}
