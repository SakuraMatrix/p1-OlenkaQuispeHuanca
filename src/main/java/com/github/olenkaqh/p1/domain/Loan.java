package com.github.olenkaqh.p1.domain;

import java.util.Objects;
import java.util.UUID;

public class Loan {

    int loanID;
    int lenderId; //lender information maybe switch to user id later
    int borrowerId; //borrower information maybe switch to user id later
    double interestRate;
    double loanAmount;
    String loanDuration;

//    String status;

    //constructors
    public Loan(){}

    public Loan(int loanID, int lenderId, int borrowerId, double interestRate,double loanAmount, String loanDuration) {
        this.loanID = loanID;
        this.lenderId = lenderId;
        this.borrowerId = borrowerId;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;

    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanID=" + loanID +
                ", lenderId=" + lenderId +
                ", borrowerId=" + borrowerId +
                ", interestRate=" + interestRate +
                ", loanAmount=" + loanAmount +
                ", loanDuration='" + loanDuration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanID == loan.loanID && lenderId == loan.lenderId && borrowerId == loan.borrowerId && Double.compare(loan.interestRate, interestRate) == 0 && Double.compare(loan.loanAmount, loanAmount) == 0 && Objects.equals(loanDuration, loan.loanDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanID, lenderId, borrowerId, interestRate, loanAmount, loanDuration);
    }

    //getters and setters
    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
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

    public int getLenderId() {
        return lenderId;
    }

    public void setLenderId(int lenderId) {
        this.lenderId = lenderId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }
}
