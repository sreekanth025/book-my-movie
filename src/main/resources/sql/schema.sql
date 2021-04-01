
SET SQLBLANKLINES ON
SET SERVEROUTPUT ON

--bookMyShow database

DROP TABLE Time_slots;
DROP TABLE Crew;
DROP TABLE Genre;
DROP TABLE Languages;
DROP TABLE Runs_on;
DROP TABLE Seat;
DROP TABLE Ticket;
DROP TABLE Theatre;
DROP TABLE Movie;

CREATE TABLE Movie(

	movie_id varchar(100) PRIMARY KEY ,
	title varchar(50) ,
	rating decimal(3,1) check( rating > 0.0 AND rating <= 10.0 ) ,
	certification varchar(5) ,
	duration INTERVAL DAY TO SECOND ,
	release_date date ,
	about long varchar ,
	poster_id INT UNIQUE

);

/* insert into movie(duration) value (INTERVAL '02:15' HOUR TO MINUTE) */


CREATE TABLE Theatre(
	
	theatre_id varchar(100) ,
	screen_id varchar(100) ,
	name varchar(100) ,
	street varchar(100) ,
	city varchar(100) ,
	price number check ( price > 0 ) ,

	PRIMARY KEY ( theatre_id , screen_id ) 
);


CREATE TABLE Ticket(
	
	ticket_id varchar(100) PRIMARY KEY ,
	email varchar(25) ,
	booking_time timestamp 
);


CREATE TABLE Seat(

	theatre_id varchar(100) ,
	screen_id varchar(100) ,
	seat_id varchar(100) ,
	show_time timestamp ,
	show_date date ,		
	status varchar(2) check( status in ('NA','A') ) ,
	ticket_id varchar(100) ,

	CONSTRAINT fk_seat_owner FOREIGN KEY(ticket_id) 
	REFERENCES Ticket(ticket_id) ON DELETE CASCADE ,

	CONSTRAINT fk_seat_theatre FOREIGN KEY(theatre_id,screen_id) 
	REFERENCES Theatre(theatre_id,screen_id) ON DELETE CASCADE
);


CREATE TABLE Runs_on(
	
	movie_id varchar(100) ,
    	theatre_id varchar(100) ,
    	screen_id varchar(100) ,
    
    	CONSTRAINT fk_runs_movieid FOREIGN KEY (movie_id)
    	REFERENCES Movie(movie_id) ON DELETE CASCADE ,
    
    	CONSTRAINT fk_runs_theatre FOREIGN KEY (theatre_id,screen_id)
    	REFERENCES Theatre(theatre_id,screen_id) ON DELETE CASCADE
);


CREATE TABLE Languages(

    	movie_id varchar(100) ,
    	lang varchar(100) ,
    
    	CONSTRAINT fk_lang_movieid FOREIGN KEY (movie_id)
   	REFERENCES Movie(movie_id) ON DELETE CASCADE
);


CREATE TABLE Genre(

    	movie_id varchar(100) ,
    	genre varchar(100) ,

    	CONSTRAINT fk_genre_movieid FOREIGN KEY (movie_id)
    	REFERENCES Movie(movie_id) ON DELETE CASCADE
);


CREATE TABLE Crew(

    	movie_id varchar(100) ,
    	role varchar(100) ,
    	name varchar(100) ,
    	image_id INT UNIQUE ,
    
    	CONSTRAINT fk_crew_movieid FOREIGN KEY (movie_id)
    	REFERENCES Movie(movie_id) ON DELETE CASCADE
);


CREATE TABLE Time_slots(

    	theatre_id varchar(100) ,
    	screen_id varchar(100) ,
    	show_time timestamp ,
    
    	CONSTRAINT fk_slots FOREIGN KEY (theatre_id,screen_id)
    	REFERENCES Theatre(theatre_id,screen_id) ON DELETE CASCADE
);
	
	
