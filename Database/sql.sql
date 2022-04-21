
CREATE TABLE users(
	username varchar (50)  PRIMARY KEY UNIQUE NOT NULL,
	user_password varchar(50) NOT NULL,
	first_name TEXT,
	last_name TEXT
);

CREATE TABLE admins(
	username varchar (50)  PRIMARY KEY UNIQUE NOT NULL,
	user_password varchar(50) NOT NULL,
	first_name TEXT,
	last_name TEXT
);


--DROP TABLE users cascade;

CREATE TABLE accounts(
	acct_number serial PRIMARY KEY,
	acct_id int,
	balance decimal,
	acct_type TEXT,
 	username_fk text REFERENCES users (username)
);

--DROP TABLE accounts CASCADE;

	


INSERT INTO accounts(acct_number, acct_id, balance, acct_type)
VALUES (098765432, 12345, 2500.50, 'Checking'),
		(098276567, 23456, 45000.99, 'Saving'),
		(098762324, 34567, 7000.74, 'Saving'),
		(094484844, 45678, 45000.82, 'Checking');
	
SELECT * FROM accounts;

INSERT INTO users (username, user_password, first_name, last_name)
VALUES ('Tom', 'Tomhank', 'Tommy', 'Hank'),
		('Jbond', 'Jamesbond', 'James', 'Bond'),
		('Jjack', 'Jack', 'Joe', 'Jack'),
		('Jake', 'Jackson', 'Jake', 'Jackson');
	
SELECT * FROM users;


INSERT INTO admins (username, user_password, first_name, last_name)
VALUES ('Rbasnet', 'brabin', 'Rabin', 'Basnet');

select * FROM admins;

	
