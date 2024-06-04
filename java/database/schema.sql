BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	first_name VARCHAR(100);
	last_name VARCHAR(100);
	user_email VARCHAR(150);
	user_phone VARCHAR(15);
	user_city VARCHAR(50);
	user_state VARCHAR(50); NOT NULL
	user_province VARCHAR(50); NOT NULL
	user_country VARCHAR(50);
	Bio TEXT,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE campaigns (
    campaign_id SERIAL PRIMARY KEY,
    campaign_title VARCHAR(100) NOT NULL,
    campaign_start_date DATE NOT NULL,
    


);


COMMIT TRANSACTION;
