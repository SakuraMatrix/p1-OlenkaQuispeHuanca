# Project 1: Peer-to-Peer lending application 
Simple application that connects borrowers to investors directly without the need of a bank middleman.
## User stories
* Lender:
  * Lender can create an account 
  * Lender can check borrower's profile
  * Lender can send an offer to the borrower
  * Lender can see all the loan applications available 
* Borrower: 
  * Borrower can create an account 
  * Borrower can check lender's profile
  * Borrower can create a loan application
  * Borrower can send a counteroffer to the lender
  * Borrower can see all the offers for their loan application
## Technologies
* Java 8+
* Maven 
* slf4j 
* Sprint 
* Cassandra DB
* Reactor Netty
## Usage
### Run 
To run the program on the command line:
`mvn exec:java -Dexec.mainClass=App`

## RESTful API endpoints
* GET `/`: Retrieves registration form 
* GET `/users`: Retrieves all the users 
* POST `/users`: Adds a new user to the database
* GET `/users/{id}`: Retrieves the user information based on the given account ID 
* DELETE `users/{id}`: Removes a user from the database based on the given account ID if the account balance is 0
* GET `/users/{id}/loans`: Retrieves all the loans linked to the specific user
* GET `/loans`: Retrieves all loans 
* POST `loans`: Adds a new loan to the database
* GET `/loans/{id}`: Retrieves a loan information based on the given loan ID 
* DELETE `/loans/{id}`: Removes a loan from the database based on the given loan ID if the loan balance is 0
* GET `/loan-application`: Retrieves loan application form on the browser
## Future Work
* Work on testing 
* Set endpoints to update user information
* Improve current endpoints
