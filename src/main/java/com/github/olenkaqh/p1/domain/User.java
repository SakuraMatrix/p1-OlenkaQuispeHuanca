package com.github.olenkaqh.p1.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User {

        private int accountID;
        private String accountType;
        private String name;
        private String dateOfBirth;
        //        private int age;
        private String email;
        private String phoneNumber;
        private String occupation;
        private int creditScore;
        //        private Account useAccount; //account id to connect to account
        private double balance;

        //constructors
        public User(){}

        public User(int accountID, String accountType, String name, String dateOfBirth, String email, String phoneNumber, String occupation, int creditScore, double balance) {
                this.accountID = accountID;
                this.accountType = accountType;
                this.name = name;
                this.dateOfBirth = dateOfBirth;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.occupation = occupation;
                this.creditScore = creditScore;
                this.balance = balance;
        }

        @Override
        public String toString() {
                return "User{" +
                        "accountID=" + accountID +
                        ", accountType='" + accountType + '\'' +
                        ", name='" + name + '\'' +
                        ", dateOfBirth=" + dateOfBirth +
                        ", email='" + email + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", occupation='" + occupation + '\'' +
                        ", creditScore=" + creditScore +
                        ", balance=" + balance +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return accountID == user.accountID && creditScore == user.creditScore && Double.compare(user.balance, balance) == 0 && Objects.equals(accountType, user.accountType) && Objects.equals(name, user.name) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(occupation, user.occupation);
        }

        @Override
        public int hashCode() {
                return Objects.hash(accountID, accountType, name, dateOfBirth, email, phoneNumber, occupation, creditScore, balance);
        }

        //getters and setters
        public int getAccountID() {
                return accountID;
        }

        public void setAccountID(int accountID) {
                this.accountID = accountID;
        }

        public String getAccountType() {
                return accountType;
        }

        public void setAccountType(String accountType) {
                this.accountType = accountType;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDateOfBirth() {
                return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
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

        public double getBalance() {
                return balance;
        }

        public void setBalance(double balance) {
                this.balance = balance;
        }
}
