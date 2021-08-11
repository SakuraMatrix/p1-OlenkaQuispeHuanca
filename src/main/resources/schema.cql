CREATE KEYSPACE IF NOT EXISTS p2plender WITH replication =
{ 'class': 'SimpleStrategy', 'replication_factor' : 1};

--create tables
CREATE TABLE IF NOT EXISTS loan(
    loan_id uuid,
    loan_amount double,
    interest_rate double,
    loan_duration text,
    lender_id uuid,
    borrower_id uuid,
    PRIMARY KEY(loan_id)
);
CREATE TABLE IF NOT EXISTS user(
    account_id uuid,
    name text,
    date_of_birth
    email text,
    phone_num text,
    occupation text,
    credit_score int,
    balance double,
    PRIMARY KEY(account_id);
);