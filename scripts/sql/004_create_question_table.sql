CREATE TABLE QUESTION(
   QUESTION_ID VARCHAR (10) NOT NULL,
   TITLE VARCHAR (100)  NOT NULL,
   QUESTION VARCHAR (500)     NOT NULL,

   USERNAME VARCHAR(20),
   PRIMARY KEY (QUESTION_ID)
);

--//@UNDO

DROP TABLE QUESTION;