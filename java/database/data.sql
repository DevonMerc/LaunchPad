BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username, password_hash, role) VALUES
    ('joe1', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER'),
    ('jane2', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER'),
    ('Kirk3', '$2a$08$abcd12abcd34abcd56abcd78abcd90abcd12abcd34abcd56abcd78abcd90abcd12', 'ROLE_USER'),
    ('Alice4', '$2a$08$efgh34efgh56efgh78efgh90efgh12efgh34efgh56efgh78efgh90efgh12efgh34', 'ROLE_USER'),
    ('Kenny5', '$2a$08$ijkl56ijkl78ijkl90ijkl12ijkl34ijkl56ijkl78ijkl90ijkl12ijkl34ijkl56', 'ROLE_USER');

INSERT INTO campaigns (campaign_title, campaign_start_date, campaign_end_date, campaign_goal, campaign_owner_id, campaign_image, funding_progress) VALUES
    ('Campaign 1', '2024-01-01', '2024-12-31', 10000.00, 1, 'image1.png', 0.00),
    ('Campaign 2', '2024-01-01', '2024-12-31', 20000.00, 2, 'image2.png', 0.00),
    ('Campaign 3', '2024-01-01', '2024-12-31', 30000.00, 3, 'image3.png', 0.00),
    ('Campaign 4', '2024-01-01', '2024-12-31', 40000.00, 4, 'image4.png', 0.00),
    ('Campaign 5', '2024-01-01', '2024-12-31', 50000.00, 5, 'image5.png', 0.00);

INSERT INTO donations (donor_id, campaign_id, donation_amount, donation_date_time) VALUES
    (1, 1, 50.00, '2024-01-01 12:00:00'),
    (2, 2, 75.00, '2024-01-02 13:00:00'),
    (3, 3, 100.00, '2024-01-03 14:00:00'),
    (4, 4, 125.00, '2024-01-04 15:00:00'),
    (5, 5, 150.00, '2024-01-05 16:00:00');

COMMIT TRANSACTION;
