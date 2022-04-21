CREATE TABLE users (
  id serial PRIMARY KEY,
  username VARCHAR ( 50 ) UNIQUE NOT NULL,
  password VARCHAR ( 50 ) NOT NULL,
  firstname VARCHAR ( 50 ) NOT NULL,
  lastname VARCHAR ( 50 ) NOT NULL
);

SELECT * FROM users;

INSERT INTO users(username, PASSWORD, firstname, lastname)
VALUES ('rab','bas','rabin','basnet');

CREATE TABLE transactions (
  id serial PRIMARY KEY,
  username VARCHAR ( 50 ) NOT NULL,
  currency VARCHAR ( 50 ) NOT NULL,
  amount INT NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

SELECT * FROM transactions;
--DROP TABLE transactions  cascade;
