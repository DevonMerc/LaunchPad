BEGIN TRANSACTION;

--remember to drop tables in the order of MOST DEPENDENT to LEAST DEPENDENT

DROP TABLE IF EXISTS donations;
DROP TABLE IF EXISTS campaigns;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
   user_id SERIAL,
   username varchar(50) NOT NULL UNIQUE,
   password_hash varchar(200) NOT NULL,
   role varchar(50) NOT NULL,
   CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE campaigns (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    end_date DATE NOT NULL,
    goal DECIMAL(10, 2) NOT NULL,
    manager_id INTEGER NOT NULL,
    image_url VARCHAR(255),
    funding DECIMAL (10, 2) DEFAULT 0,
    description VARCHAR(500),
    is_public BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (manager_id) REFERENCES users(user_id)
);

CREATE TABLE donations (
    donation_id SERIAL PRIMARY KEY,
    donor_id INTEGER NOT NULL,
    campaign_id INTEGER NOT NULL,
    donation_amount DECIMAL(10, 2) NOT NULL,
    donation_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (donor_id) REFERENCES users(user_id),
    FOREIGN KEY (campaign_id) REFERENCES campaigns(id)

);
