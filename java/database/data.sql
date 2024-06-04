BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username, first_name, last_name, user_email, user_phone, user_city, user_state, user_province, user_country, bio, password_hash, role)
VALUES
    ('jdoe1', 'John', 'Doe', 'jdoe1@example.com', '123-456-7890', 'New York', 'NY', 'NY', 'USA', 'Bio for John Doe 1', 'hash1', 'user'),
    ('jdoe2', 'Jane', 'Doe', 'jdoe2@example.com', '123-456-7891', 'Los Angeles', 'CA', 'CA', 'USA', 'Bio for Jane Doe 2', 'hash2', 'admin'),
    ('jdoe3', 'Alice', 'Smith', 'jdoe3@example.com', '123-456-7892', 'Chicago', 'IL', 'IL', 'USA', 'Bio for Alice Smith 3', 'hash3', 'user'),
    ('jdoe4', 'Bob', 'Johnson', 'jdoe4@example.com', '123-456-7893', 'Houston', 'TX', 'TX', 'USA', 'Bio for Bob Johnson 4', 'hash4', 'user'),
    ('jdoe5', 'Charlie', 'Brown', 'jdoe5@example.com', '123-456-7894', 'Phoenix', 'AZ', 'AZ', 'USA', 'Bio for Charlie Brown 5', 'hash5', 'user'),
    ('jdoe6', 'David', 'Wilson', 'jdoe6@example.com', '123-456-7895', 'Philadelphia', 'PA', 'PA', 'USA', 'Bio for David Wilson 6', 'hash6', 'user'),
    ('jdoe7', 'Eva', 'Davis', 'jdoe7@example.com', '123-456-7896', 'San Antonio', 'TX', 'TX', 'USA', 'Bio for Eva Davis 7', 'hash7', 'user'),
    ('jdoe8', 'Frank', 'Miller', 'jdoe8@example.com', '123-456-7897', 'San Diego', 'CA', 'CA', 'USA', 'Bio for Frank Miller 8', 'hash8', 'user'),
    ('jdoe9', 'Grace', 'Garcia', 'jdoe9@example.com', '123-456-7898', 'Dallas', 'TX', 'TX', 'USA', 'Bio for Grace Garcia 9', 'hash9', 'user'),
    ('jdoe10', 'Hannah', 'Martinez', 'jdoe10@example.com', '123-456-7899', 'San Jose', 'CA', 'CA', 'USA', 'Bio for Hannah Martinez 10', 'hash10', 'user'),
    ('jdoe11', 'Ian', 'Anderson', 'jdoe11@example.com', '123-456-7900', 'Austin', 'TX', 'TX', 'USA', 'Bio for Ian Anderson 11', 'hash11', 'user'),
    ('jdoe12', 'Jane', 'Thomas', 'jdoe12@example.com', '123-456-7901', 'Jacksonville', 'FL', 'FL', 'USA', 'Bio for Jane Thomas 12', 'hash12', 'user'),
    ('jdoe13', 'Kevin', 'White', 'jdoe13@example.com', '123-456-7902', 'San Francisco', 'CA', 'CA', 'USA', 'Bio for Kevin White 13', 'hash13', 'user'),
    ('jdoe14', 'Laura', 'Harris', 'jdoe14@example.com', '123-456-7903', 'Columbus', 'OH', 'OH', 'USA', 'Bio for Laura Harris 14', 'hash14', 'user'),
    ('jdoe15', 'Michael', 'Clark', 'jdoe15@example.com', '123-456-7904', 'Fort Worth', 'TX', 'TX', 'USA', 'Bio for Michael Clark 15', 'hash15', 'user'),
    ('jdoe16', 'Nancy', 'Rodriguez', 'jdoe16@example.com', '123-456-7905', 'Charlotte', 'NC', 'NC', 'USA', 'Bio for Nancy Rodriguez 16', 'hash16', 'user'),
    ('jdoe17', 'Oscar', 'Lewis', 'jdoe17@example.com', '123-456-7906', 'Detroit', 'MI', 'MI', 'USA', 'Bio for Oscar Lewis 17', 'hash17', 'user'),
    ('jdoe18', 'Paula', 'Walker', 'jdoe18@example.com', '123-456-7907', 'El Paso', 'TX', 'TX', 'USA', 'Bio for Paula Walker 18', 'hash18', 'user'),
    ('jdoe19', 'Quincy', 'Hall', 'jdoe19@example.com', '123-456-7908', 'Seattle', 'WA', 'WA', 'USA', 'Bio for Quincy Hall 19', 'hash19', 'user'),
    ('jdoe20', 'Rachel', 'Allen', 'jdoe20@example.com', '123-456-7909', 'Denver', 'CO', 'CO', 'USA', 'Bio for Rachel Allen 20', 'hash20', 'user');

    INSERT INTO campaigns (campaign_title, campaign_start_date, campaign_end_date, campaign_category, campaign_description, campaign_goal, campaign_location, campaign_owner_id, campaign_image, funding_process)
    VALUES
        ('Campaign 1', '2024-01-01', '2024-12-31', 'Health', 'Description for Campaign 1', 10000.00, 'New York', 1, 'image1.png', 0.00),
        ('Campaign 2', '2024-01-01', '2024-12-31', 'Education', 'Description for Campaign 2', 20000.00, 'Los Angeles', 2, 'image2.png', 0.00),
        ('Campaign 3', '2024-01-01', '2024-12-31', 'Environment', 'Description for Campaign 3', 30000.00, 'Chicago', 3, 'image3.png', 0.00),
        ('Campaign 4', '2024-01-01', '2024-12-31', 'Technology', 'Description for Campaign 4', 40000.00, 'Houston', 4, 'image4.png', 0.00),
        ('Campaign 5', '2024-01-01', '2024-12-31', 'Arts', 'Description for Campaign 5', 50000.00, 'Phoenix', 5, 'image5.png', 0.00),
        ('Campaign 6', '2024-01-01', '2024-12-31', 'Sports', 'Description for Campaign 6', 60000.00, 'Philadelphia', 6, 'image6.png', 0.00),
        ('Campaign 7', '2024-01-01', '2024-12-31', 'Music', 'Description for Campaign 7', 70000.00, 'San Antonio', 7, 'image7.png', 0.00),
        ('Campaign 8', '2024-01-01', '2024-12-31', 'Community', 'Description for Campaign 8', 80000.00, 'San Diego', 8, 'image8.png', 0.00),
        ('Campaign 9', '2024-01-01', '2024-12-31', 'Business', 'Description for Campaign 9', 90000.00, 'Dallas', 9, 'image9.png', 0.00),
        ('Campaign 10', '2024-01-01', '2024-12-31', 'Charity', 'Description for Campaign 10', 100000.00, 'San Jose', 10, 'image10.png', 0.00),
        ('Campaign 11', '2024-01-01', '2024-12-31', 'Health', 'Description for Campaign 11', 110000.00, 'Austin', 11, 'image11.png', 0.00),
        ('Campaign 12', '2024-01-01', '2024-12-31', 'Education', 'Description for Campaign 12', 120000.00, 'Jacksonville', 12, 'image12.png', 0.00),
        ('Campaign 13', '2024-01-01', '2024-12-31', 'Environment', 'Description for Campaign 13', 130000.00, 'San Francisco', 13, 'image13.png', 0.00),
        ('Campaign 14', '2024-01-01', '2024-12-31', 'Technology', 'Description for Campaign 14', 140000.00, 'Columbus', 14, 'image14.png', 0.00),
        ('Campaign 15', '2024-01-01', '2024-12-31', 'Arts', 'Description for Campaign 15', 150000.00, 'Fort Worth', 15, 'image15.png', 0.00),
        ('Campaign 16', '2024-01-01', '2024-12-31', 'Sports', 'Description for Campaign 16', 160000.00, 'Charlotte', 16, 'image16.png', 0.00),
        ('Campaign 17', '2024-01-01', '2024-12-31', 'Music', 'Description for Campaign 17', 170000.00, 'Detroit', 17, 'image17.png', 0.00),
        ('Campaign 18', '2024-01-01', '2024-12-31', 'Community', 'Description for Campaign 18', 180000.00, 'El Paso', 18, 'image18.png', 0.00),
        ('Campaign 19', '2024-01-01', '2024-12-31', 'Business', 'Description for Campaign 19', 190000.00, 'Seattle', 19, 'image19.png', 0.00),
        ('Campaign 20', '2024-01-01', '2024-12-31', 'Charity', 'Description for Campaign 20', 200000.00, 'Denver', 20, 'image20.png', 0.00);

    INSERT INTO donations (donor_id, campaign_id, donation_amount, donation_date_time, payment_method, transaction_id, donor_comments)
    VALUES
        (1, 1, 50.00, '2024-01-01 12:00:00', 'Credit Card', 'TXN001', 'Comment for Donation 1'),
        (2, 2, 75.00, '2024-01-02 13:00:00', 'PayPal', 'TXN002', 'Comment for Donation 2'),
        (3, 3, 100.00, '2024-01-03 14:00:00', 'Credit Card', 'TXN003', 'Comment for Donation 3'),
        (4, 4, 125.00, '2024-01-04 15:00:00', 'PayPal', 'TXN004', 'Comment for Donation 4'),
        (5, 5, 150.00, '2024-01-05 16:00:00', 'Credit Card', 'TXN005', 'Comment for Donation 5'),
        (6, 6, 175.00, '2024-01-06 17:00:00', 'PayPal', 'TXN006', 'Comment for Donation 6'),
        (7, 7, 200.00, '2024-01-07 18:00:00', 'Credit Card', 'TXN007', 'Comment for Donation 7'),
        (8, 8, 225.00, '2024-01-08 19:00:00', 'PayPal', 'TXN008', 'Comment for Donation 8'),
        (9, 9, 250.00, '2024-01-09 20:00:00', 'Credit Card', 'TXN009', 'Comment for Donation 9'),
        (10, 10, 275.00, '2024-01-10 21:00:00', 'PayPal', 'TXN010', 'Comment for Donation 10'),
        (11, 11, 300.00, '2024-01-11 22:00:00', 'Credit Card', 'TXN011', 'Comment for Donation 11'),
        (12, 12, 325.00, '2024-01-12 23:00:00', 'PayPal', 'TXN012', 'Comment for Donation 12'),
        (13, 13, 350.00, '2024-01-13 24:00:00', 'Credit Card', 'TXN013', 'Comment for Donation 13'),
        (14, 14, 375.00, '2024-01-14 01:00:00', 'PayPal', 'TXN014', 'Comment for Donation 14'),
        (15, 15, 400.00, '2024-01-15 02:00:00', 'Credit Card', 'TXN015', 'Comment for Donation 15'),
        (16, 16, 425.00, '2024-01-16 03:00:00', 'PayPal', 'TXN016', 'Comment for Donation 16'),
        (17, 17, 450.00, '2024-01-17 04:00:00', 'Credit Card', 'TXN017', 'Comment for Donation 17'),
        (18, 18, 475.00, '2024-01-18 05:00:00', 'PayPal', 'TXN018', 'Comment for Donation 18'),
        (19, 19, 500.00, '2024-01-19 06:00:00', 'Credit Card', 'TXN019', 'Comment for Donation 19'),
        (20, 20, 525.00, '2024-01-20 07:00:00', 'PayPal', 'TXN020', 'Comment for Donation 20');

    INSERT INTO campaign_videos (campaign_id, video_url)
    VALUES
        (1, 'http://example.com/video1'),
        (2, 'http://example.com/video2'),
        (3, 'http://example.com/video3'),
        (4, 'http://example.com/video4'),
        (5, 'http://example.com/video5'),
        (6, 'http://example.com/video6'),
        (7, 'http://example.com/video7'),
        (8, 'http://example.com/video8'),
        (9, 'http://example.com/video9'),
        (10, 'http://example.com/video10'),
        (11, 'http://example.com/video11'),
        (12, 'http://example.com/video12'),
        (13, 'http://example.com/video13'),
        (14, 'http://example.com/video14'),
        (15, 'http://example.com/video15'),
        (16, 'http://example.com/video16'),
        (17, 'http://example.com/video17'),
        (18, 'http://example.com/video18'),
        (19, 'http://example.com/video19'),
        (20, 'http://example.com/video20');

    INSERT INTO campaign_updates (campaign_id, update_date, update_content)
    VALUES
        (1, '2024-01-01', 'Update content for Campaign 1'),
        (2, '2024-01-02', 'Update content for Campaign 2'),
        (3, '2024-01-03', 'Update content for Campaign 3'),
        (4, '2024-01-04', 'Update content for Campaign 4'),
        (5, '2024-01-05', 'Update content for Campaign 5'),
        (6, '2024-01-06', 'Update content for Campaign 6'),
        (7, '2024-01-07', 'Update content for Campaign 7'),
        (8, '2024-01-08', 'Update content for Campaign 8'),
        (9, '2024-01-09', 'Update content for Campaign 9'),
        (10, '2024-01-10', 'Update content for Campaign 10'),
        (11, '2024-01-11', 'Update content for Campaign 11'),
        (12, '2024-01-12', 'Update content for Campaign 12'),
        (13, '2024-01-13', 'Update content for Campaign 13'),
        (14, '2024-01-14', 'Update content for Campaign 14'),
        (15, '2024-01-15', 'Update content for Campaign 15'),
        (16, '2024-01-16', 'Update content for Campaign 16'),
        (17, '2024-01-17', 'Update content for Campaign 17'),
        (18, '2024-01-18', 'Update content for Campaign 18'),
        (19, '2024-01-19', 'Update content for Campaign 19'),
        (20, '2024-01-20', 'Update content for Campaign 20');

COMMIT TRANSACTION;
