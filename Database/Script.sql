--To create a new schema, we right clicked the schemas folder, create new sschema, and named it ddl_datatypes
--Then,  to create this file , we right clicked our schema -> SQL Editor -> Open SQL Script




CREATE TABLE users(
username TEXT
);

--we can use ALTER command to change or add columns
ALTER TABLE users ADD user_age int;

--we can also rename columns using alter
ALTER TABLE users RENAME  user_age TO users_age;

--we can DROP  a table with DROP command
DROP TABLE users;

--TRUNCATE , which drops all records in a table
--DROP deletes a table/column(all the data)
--TRUNCATE only deletes the data.

--SQL Datatypes----

CREATE TABLE datatypes (
	small_number int2, --2 bytes, FOR smaller numbers(kinda like a short in Java)
	normal_number int, --4 bytes, most common int TYPE (can also be int4)
	big_numbers int8, --8 bytes, FOR swle numbers(kinda like long in Java)
	standard_decimal decimal(10, 2), --2 parameters: (total digits, decimal places)
	--so this decimal has 10 total digits, with 2 decimal places.
	
	"boolean" boolean, -- double quotes let you use keywords AS COLUMN names, etc.
	
	fixed_lenght_text char(2), -- TEXT field, IN this CASE we  give it 2, which means it can ONLY be 2 CHARACTERS long
	variable_length_text varchar(15), --TEXT field, we gace it 15 so it can be BETWEEN 0-15 charaters long
	unlimited_length_text TEXT, -- unlimited length, best practice IF you don't need TO LIMIT your CHARACTERS.
	
	"date" date, --YYYY-MM-DD
	"timestamp" timestamp --YYYY-MM HH-SS

);