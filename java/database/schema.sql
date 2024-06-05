BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE campaigns (
    campaign_id SERIAL PRIMARY KEY,
    campaign_title VARCHAR(100) NOT NULL,
    campaign_start_date DATE NOT NULL,
    campaign_end_date DATE NOT NULL,
    campaign_goal DECIMAL(10, 2) NOT NULL,
    campaign_owner_id INTEGER NOT NULL,
    campaign_image VARCHAR(255),
    funding_progress DECIMAL (10, 2) DEFAULT 0,
    FOREIGN KEY (campaign_owner_id) REFERENCES users(user_id)
);

CREATE TABLE donations (
    donation_id SERIAL PRIMARY KEY,
    donor_id INTEGER NOT NULL,
    campaign_id INTEGER NOT NULL,
    donation_amount DECIMAL(10, 2) NOT NULL,
    donation_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (donor_id) REFERENCES users(user_id),
    FOREIGN KEY (campaign_id) REFERENCES campaigns(campaign_iD)
);

COMMIT TRANSACTION;
