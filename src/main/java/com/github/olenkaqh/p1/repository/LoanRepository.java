package com.github.olenkaqh.p1.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.github.olenkaqh.p1.domain.Loan;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;
@Repository
public class LoanRepository {
    private CqlSession session;
    //constructor
    public LoanRepository(CqlSession session){
        this.session = session;
    }

    //get all loans
    public Flux<Loan> getAll(){
        return Flux.from(session.executeReactive("SELECT * FROM p2plender.loan")).map(row -> new Loan(row.getInt("loan_id"),
                row.getInt("lender_id"),
                row.getInt("borrower_id"),
                row.getDouble("interest_rate"),
                row.getDouble("loan_amount"),
                row.getString("loan_duration")));
    }

    //get a single loan from loans
    public Mono<Loan> get(int id){
//        System.out.println("id: " + id);
        return Mono.from(session.executeReactive("SELECT * FROM p2plender.loan WHERE loan_id = " + id )).map(row -> new Loan(row.getInt("loan_id"),
                row.getInt("lender_id"),
                row.getInt("borrower_id"),
                row.getDouble("interest_rate"),
                row.getDouble("loan_amount"),
                row.getString("loan_duration")));
    }

    //    //get loans specific to user
//    public Flux<Loan> getBorrowerLoans(int id){
//        return Flux.from(session.executeReactive("SELECT * FROM p2plender.loan WHERE borrower_id = " + id + "ALLOW FILTERING")).map(row -> new Loan(row.getInt("loan_id"),
//                row.getInt("lender_id"),
//                row.getInt("borrower_id"),
//                row.getDouble("interest_rate"),
//                row.getDouble("loan_amount"),
//                row.getString("loan_duration")));
//    }
    //create a new loan
    public Loan create(Loan loan){
        SimpleStatement stm = SimpleStatement.builder("INSERT INTO p2plender.loan (loan_id, loan_amount, interest_rate, loan_duration, lender_id,borrower_id) VALUES (?,?,?,?,?,?)")
                .addPositionalValues(loan.getLoanID(),loan.getLoanAmount(),loan.getInterestRate(),loan.getLoanDuration(),loan.getLenderId(),loan.getBorrowerId())
                .build();
        Flux.from(session.executeReactive(stm)).subscribe();

        return loan;
    }

}