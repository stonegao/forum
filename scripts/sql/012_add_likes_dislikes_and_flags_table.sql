ALTER TABLE QUESTION
ADD (LIKES INTEGER DEFAULT 0,
DISLIKES INTEGER DEFAULT 0,
FLAGS INTEGER DEFAULT 0
);
--//@UNDO
ALTER TABLE QUESTION
DROP COLUMN LIKES,
DROP COLUMN DISLIKES,
DROP COLUMN FLAGS;
