package com.github.olenkaqh.p1.domain;

import java.util.UUID;

public class Loan {

    UUID loanID;
    double loanAmount;
    double interestRate;
    String loanDuration;
    UUID lenderId; //lender information maybe switch to user id later
    UUID borrowerId; //borrower information maybe switch to user id later
//    String status;

    //constructors
    public Loan(){}

    public Loan(UUID loanID, double loanAmount, double interestRate, String loanDuration, UUID lenderId, UUID borrowerId) {
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
        this.lenderId = lenderId;
        this.borrowerId = borrowerId;
    }

    //getters and setters
    public UUID getLoanID() {
        return loanID;
    }

    public void setLoanID(UUID loanID) {
        this.loanID = loanID;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(String loanDuration) {
        this.loanDuration = loanDuration;
    }

    public UUID getLenderId() {
        return lenderId;
    }

    public void setLenderId(UUID lenderId) {
        this.lenderId = lenderId;
    }

    public UUID getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(UUID borrowerId) {
        this.borrowerId = borrowerId;
    }
}
