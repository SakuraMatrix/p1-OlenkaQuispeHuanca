package com.github.olenkaqh.p1.domain;

import com.github.olenkaqh.p1.domain.Account;

import java.time.LocalDate;
import java.util.UUID;

public class User {

        private String name;
        private LocalDate dateOfBirth;
        private int age;
        private String email;
        private String phoneNumber;
        private String occupation;
        private int creditScore;
        private UUID accountID;
//        private Account useAccount; //account id to connect to account
        private double balance;

        //constructors
        public User(){}

        public User(String name, LocalDate dateOfBirth, int age, String email, String phoneNumber, String occupation, int creditScore, UUID accountID, double balance) {
                this.name = name;
                this.dateOfBirth = dateOfBirth;
                this.age = age;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.occupation = occupation;
                this.creditScore = creditScore;
                this.accountID = accountID;
                this.balance = balance;
        }

        //getters and setters
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public LocalDate getDateOfBirth() {
                return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getOccupation() {
                return occupation;
        }

        public void setOccupation(String occupation) {
                this.occupation = occupation;
        }

        public int getCreditScore() {
                return creditScore;
        }

        public void setCreditScore(int creditScore) {
                this.creditScore = creditScore;
        }

        public UUID getAccountID() {
                return accountID;
        }

        public void setAccountID(UUID accountID) {
                this.accountID = accountID;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }
}
