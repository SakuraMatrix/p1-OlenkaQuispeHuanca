-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS p2plender WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor' : '1'};

--create tables
CREATE TABLE IF NOT EXISTS p2plender.loan(
    loan_id int,
    loan_amount double,
    interest_rate double,
    loan_duration text,
    lender_id int,
    borrower_id int,
    PRIMARY KEY(loan_id)
);
CREATE TABLE IF NOT EXISTS p2plender.user(
    account_id int,
    account_type text,
    name text,
    date_of_birth text,
    email text,
    phone_num text,
    occupation text,
    credit_score int,
    balance double,
    PRIMARY KEY(account_id)
);
--loans
INSERT INTO p2plender.loan(loan_id, loan_amount, interest_rate, loan_duration, lender_id,borrower_id)
    VALUES (1, 2000, 4, '2 years', 4, 1 );
INSERT INTO p2plender.loan(loan_id, loan_amount, interest_rate, loan_duration, lender_id,borrower_id)
    VALUES (2, 10000, 6.5, '5 years', 4, 2 );
INSERT INTO p2plender.loan(loan_id, loan_amount, interest_rate, loan_duration, lender_id,borrower_id)
    VALUES (3, 5000, 5, '1 years', 4, 3 );
--    users
 INSERT INTO p2plender.user(account_id, account_type, name, date_of_birth, email, phone_num, occupation, credit_score, balance)
    VALUES (1,'Borrower','John Smith','1993-01-01', 'john.smith@gmail.com','1234567890', 'Teacher',690,2000 );
 INSERT INTO p2plender.user(account_id, account_type, name, date_of_birth, email, phone_num, occupation, credit_score, balance)
    VALUES (2,'Borrower','Sam Doe','1988-10-08', 'sam.doe@gmail.com','6461234567', 'Janitor',600,2000 );
 INSERT INTO p2plender.user(account_id, account_type, name, date_of_birth, email, phone_num, occupation, credit_score, balance)
    VALUES (3,'Borrower','Susan King','1995-06-11', 'susan.king@gmail.com','9876543210', 'Bartender',500,5000 );
 INSERT INTO p2plender.user(account_id, account_type, name, date_of_birth, email, phone_num, occupation, credit_score, balance)
    VALUES (4,'Lender','Marcus Gibson','1972-12-03', 'marcus.gibson@gmail.com','6789012345', 'Investor',810,0 );
