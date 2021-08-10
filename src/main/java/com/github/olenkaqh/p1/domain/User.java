package com.github.olenkaqh.p1.domain;

import com.github.olenkaqh.p1.domain.Account;

import java.time.LocalDate;

public class User {
        private String name;
        private LocalDate dateOfBirth;
        private int age;
        private String email;
        private String phoneNumber;
        private String occupation;
        private int creditScore;
        private Account useAccount; //account id to connect to account

}
