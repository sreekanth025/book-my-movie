--to be run after every transaction
COMMIT;

--inserting records in Movie table
INSERT INTO Movie VALUES('MV001','Godzilla vs. Kong',	7.1,'UA',114,'12-MAR-21',
'This fantasy action drama brings the two fearsome monsters, Godzilla and Kong, face to face. As the monsters fight it out in a battle of grand proportions, 
humanity must find a way to survive and secure its future','testlink1');


--inserting records into Languages table
INSERT INTO Languages VALUES(	 'MV001'	,	  'English'	);
INSERT INTO Languages VALUES(	 'MV001',	 'Hindi'	);
INSERT INTO Languages VALUES(	 'MV001'	,	 'Telugu'	);
INSERT INTO Languages VALUES(	 'MV001'	,	 'Tamil'	);


--inserting records into Genre table
INSERT INTO Genre VALUES(	 'MV001',	 'Action'	);
INSERT INTO Genre VALUES(	 'MV001'	,	 'Fantasy'	);
INSERT INTO Genre VALUES(	 'MV001',	 'Sci-Fi'	);
INSERT INTO Genre VALUES(	 'MV001'	,	 'Thriller'	);

--Inserting into "Crew" table
INSERT INTO Crew VALUES(	  'MV001',	 'Director'	,	 'Adam Wingard'	,	'img-link-1'	);
INSERT INTO Crew VALUES(	 'MV001',	'Producer'	,	 'Jon Jashni'	,	'img-link-2'	);
INSERT INTO Crew VALUES(	  'MV001',	'Producer'	,	 'Eric McLeod'	,	'img-link-3'	);
INSERT INTO Crew VALUES(	 'MV001',	'Writer'	,	 'Terry Rossio'	,	'img-link-4'	);
INSERT INTO Crew VALUES(	 'MV001',	'Screenplay'	,	 'Eric Pearson'	,	'img-link-5'	);
INSERT INTO Crew VALUES(	 'MV001',	 'Actor'	,	 'Alexander Skarsgard'	,	'img-link-6'	);
INSERT INTO Crew VALUES(	 'MV001',	 'Actor'	,	 'Millie Bobby Brown'	,	'img-link-7'	);
INSERT INTO Crew VALUES(	 'MV001',	 'Actor'	,	 'Rebecca Hall'	,	'img-link-8'	);
INSERT INTO Crew VALUES(	  'MV001',	 'Actor'	,	 'Brian Tyree Henry'	,	'img-link-9'	);


--Inserting values in "Theatre" table
INSERT INTO Theatre VALUES('TH001','SC001','dummyTheatre1','street1','city1',150);
INSERT INTO Theatre VALUES('TH001','SC002','dummyTheatre2','street2','city2',200);
INSERT INTO Theatre VALUES('TH001','SC003','dummyTheatre3','street3','city3',250);
INSERT INTO Theatre VALUES('TH001','SC004','dummyTheatre4','street4','city4',100);
INSERT INTO Theatre VALUES('TH001','SC005','dummyTheatre5','street5','city5',300);


--Inserting into "Runs_on" table
INSERT INTO Runs_on VALUES('MV001','TH001','SC001','English',TO_TIMESTAMP('2021-04-04 06:15:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Runs_on VALUES('MV001','TH001','SC002','Hindi',TO_TIMESTAMP('2021-04-05 19:15:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO Runs_on VALUES('MV001','TH001','SC003','Telugu',TO_TIMESTAMP('2021-04-06 16:15:00', 'YYYY-MM-DD HH24:MI:SS.'));
INSERT INTO Runs_on VALUES('MV001','TH001','SC004','Tamil',TO_TIMESTAMP('2021-04-07 18:15:00', 'YYYY-MM-DD HH24:MI:SS'));

--Inserting into Seat table
INSERT INTO Seat VALUES();
INSERT INTO Seat VALUES();
INSERT INTO Seat VALUES();
INSERT INTO Seat VALUES();

--Inserting into "Ticket table"



