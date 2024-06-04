BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	user_email VARCHAR(150),
	user_phone VARCHAR(15),
	user_city VARCHAR(50),
	user_state VARCHAR(50),
	user_province VARCHAR(50),
	user_country VARCHAR(50),
	Bio TEXT,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE campaigns (
    campaign_id SERIAL PRIMARY KEY,
    campaign_title VARCHAR(100) NOT NULL,
    campaign_start_date DATE NOT NULL,
    campaign_end_date DATE NOT NULL,
    campaign_category VARCHAR(50) NOT NULL,
    campaign_description TEXT NOT NULL,
    campaign_goal DECIMAL(10, 2) NOT NULL,
    campaign_location VARCHAR (100),
    campaign_owner_id INTEGER NOT NULL,
    campaign_image VARCHAR(255),
    funding_process DECIMAL (10, 2) DEFAULT 0,
    FOREIGN KEY (campaign_owner_id) REFERENCES users(user_id)
);

CREATE TABLE donations (
    donation_id SERIAL PRIMARY KEY,
    donor_id INTEGER NOT NULL,
    campaign_id INTEGER NOT NULL,
    donation_amount DECIMAL(10, 2) NOT NULL,
    donation_date_time TIMESTAMP NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    transaction_id VARCHAR(100) NOT NULL,
    donor_comments TEXT,
    FOREIGN KEY (donor_id) REFERENCES users(user_id),
    FOREIGN KEY (campaign_id) REFERENCES campaigns(campaign_iD)
);

CREATE TABLE campaign_videos (
    video_id SERIAL PRIMARY KEY,
    campaign_id INTEGER NOT NULL,
    video_url VARCHAR(255) NOT NULL,
    FOREIGN KEY (campaign_id) REFERENCES campaigns(campaign_id)
);

CREATE TABLE campaign_updates (
    update_id SERIAL PRIMARY KEY,
    campaign_id INTEGER NOT NULL,
    update_date DATE NOT NULL,
    update_content TEXT NOT NULL,
    FOREIGN KEY (campaign_id) REFERENCES campaigns(campaign_id)
);

COMMIT TRANSACTION;
