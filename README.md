# Project 1: Peer-to-Peer lending application 
Restful API for a peer to peer lending application that connects borrowers to investors directly without the need of a bank middleman.
## Technologies
* Java 8+
* Maven 
* slf4j 
* Spring Framework
* Cassandra DB
* Reactor Netty
## User stories
* Lender:
  * Lender can create an account 
  * Lender can check borrower's profile
  * Lender can see all the loan applications available 
* Borrower: 
  * Borrower can create an account 
  * Borrower can check lender's profile
  * Borrower can create a loan application
## Getting Started
To start clone the repository
`git clone https://github.com/SakuraMatrix/p1-OlenkaQuispeHuanca.git`
## Usage
### Compile 
To compile the program use:
`mvn compile`
### Run 
To run the program on the command line:
`mvn exec:java -Dexec.mainClass=App`
### Clean
To clean up artifacts created by prior builds:  
`mvn clean`
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
