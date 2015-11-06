CREATE DATABASE ac;
USE ac;
CREATE TABLE users(
	id INTEGER AUTO_INCREMENT,
	username CHAR(64),
	password CHAR(64),
	email CHAR(64),
	PRIMARY KEY (id)
);
