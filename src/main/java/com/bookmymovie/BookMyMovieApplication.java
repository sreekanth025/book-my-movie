package com.bookmymovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:config.properties")
})
//Include the config.properties file containing login information
public class BookMyMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyMovieApplication.class, args);
	}

}
