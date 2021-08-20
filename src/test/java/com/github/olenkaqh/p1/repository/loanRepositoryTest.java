package com.github.olenkaqh.p1.repository;

import com.github.olenkaqh.p1.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import reactor.test.StepVerifier;

@SpringJUnitConfig(classes = AppConfig.class)
public class loanRepositoryTest {
    @Autowired
    LoanRepository loanRepository;

    //TODO: Fix test
//        @Test
//        public void testAddLoan() {
//            Loan loan = new Loan(6,5,3,6.5,5600,"3 years");
//            StepVerifier.create(loanRepository.create(loan))
//                    .consumeNextWith(Loan::getLoanID)
//                    .verifyComplete();
//        }

    @Test
    public void testGetLoan(){
        StepVerifier.create(loanRepository.get(1))
                .consumeNextWith( loan -> Assertions.assertEquals(1, loan.getLoanID()))
                .verifyComplete();
    }
    //TODO: Fix test
    @Test
    public void testDeleteLoan(){
        StepVerifier.create(loanRepository.delete(4))
                .consumeNextWith( loan -> Assertions.assertEquals(4, loan.getLoanID()))
                .verifyComplete();
    }
}
