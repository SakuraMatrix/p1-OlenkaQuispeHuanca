package com.github.olenkaqh.p1.domain;

import java.util.UUID;

public class Loan {  // data members
    UUID loanID;
    double loanAmount;
    double interestRate;
    int loanDuration;
    String lender; //lender information maybe switch to user id later
    String borrower; //borrower information maybe switch to user id later
    String status;

}
