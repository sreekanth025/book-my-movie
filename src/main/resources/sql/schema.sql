
SET SQLBLANKLINES ON
SET SERVEROUTPUT ON

--bookMyShow database

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
	duration int ,
	release_date date ,
	about long varchar ,
	poster_link varchar(100) UNIQUE


);


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
	email varchar(100) ,
	booking_time timestamp 
);


CREATE TABLE Seat(

	theatre_id varchar(100) ,
	screen_id varchar(100) ,
	seat_id varchar(100) ,
	show_time timestamp ,
	show_date date ,		
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
    	language varchar(100) ,
	show_time timestamp ,

    	CONSTRAINT fk_runs_movieid FOREIGN KEY (movie_id)
    	REFERENCES Movie(movie_id) ON DELETE CASCADE ,
    
    	CONSTRAINT fk_runs_theatre FOREIGN KEY (theatre_id,screen_id)
    	REFERENCES Theatre(theatre_id,screen_id) ON DELETE CASCADE
);
ROLLBACK;

CREATE TABLE Languages(

    	movie_id varchar(100) ,
    	language varchar(100) ,
    
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
    	image_link varchar(100),

    
    	CONSTRAINT fk_crew_movieid FOREIGN KEY (movie_id)
    	REFERENCES Movie(movie_id) ON DELETE CASCADE
);

DROP SEQUENCE ticket_sequence;
CREATE SEQUENCE ticket_sequence
MINVALUE 1
START WITH 1
INCREMENT BY 1;	
