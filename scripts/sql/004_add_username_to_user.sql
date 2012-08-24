ALTER TABLE USER ADD COLUMN USERNAME VARCHAR(40) NOT NULL
, ADD UNIQUE INDEX USERNAME_UNIQUE (USERNAME ASC) ;

--//@UNDO

ALTER TABLE USER DROP COLUMN USERNAME
, DROP INDEX USERNAME_UNIQUE ;