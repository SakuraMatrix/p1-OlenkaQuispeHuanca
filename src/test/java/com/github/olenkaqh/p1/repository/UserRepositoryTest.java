package com.github.olenkaqh.p1.repository;

import com.github.olenkaqh.p1.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import reactor.test.StepVerifier;

@SpringJUnitConfig(classes = AppConfig.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
//TODO: Fix test
//    @Test
//    public void testAddUser(){
//        StepVerifier.create(userRepository.create(new User(6,"Borrower","Test Test","1980-10-19","test@gmail.com","1234567890","Waiter",400)))
//                .consumeNextWith( User::getAccountID)
//                .verifyComplete();
//    }

    @Test
    public void testGetUser(){
        StepVerifier.create(userRepository.get(1))
                .consumeNextWith( user -> Assertions.assertEquals(1, user.getAccountID()))
                .verifyComplete();
    }
    //TODO: Fix test
    @Test
    public void testDeleteUser() {
        StepVerifier.create(userRepository.delete(5))
                .consumeNextWith(user -> Assertions.assertEquals(5, user.getAccountID()))
                .verifyComplete();
    }


}
