BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username, password_hash)
VALUES
    ('jdoe1', 'hash1'),
    ('jdoe2', 'hash2'),
    ('jdoe3', 'hash3'),
    ('jdoe4', 'hash4'),
    ('jdoe5', 'hash5'),


INSERT INTO campaigns (campaign_id, campaign_title, campaign_start_date, campaign_end_date, campaign_goal, campaign_owner_id, campaign_image, funding_process)
VALUES
     (01, 'Campaign 1', '2024-01-01', '2024-12-31', 10000.00, 1, 'image1.png', 0.00),
     (02, 'Campaign 2', '2024-01-01', '2024-12-31', 20000.00, 2, 'image2.png', 0.00),
     (03, 'Campaign 3', '2024-01-01', '2024-12-31', 30000.00, 3, 'image3.png', 0.00),
     (04, 'Campaign 4', '2024-01-01', '2024-12-31', 40000.00, 4, 'image4.png', 0.00),
     (05, 'Campaign 5', '2024-01-01', '2024-12-31', 50000.00, 5, 'image5.png', 0.00),


INSERT INTO donations (donor_id, campaign_id, donation_amount, donation_date_time)
VALUES
     (1, 01, 50.00, '2024-01-01 12:00:00'),
     (2, 02, 75.00, '2024-01-02 13:00:00'),
     (3, 03, 100.00, '2024-01-03 14:00:00'),
     (4, 04, 125.00, '2024-01-04 15:00:00'),
     (5, 05, 150.00, '2024-01-05 16:00:00'),


COMMIT TRANSACTION;
