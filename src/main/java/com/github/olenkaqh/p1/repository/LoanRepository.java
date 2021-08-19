package com.github.olenkaqh.p1.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.github.olenkaqh.p1.domain.Loan;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class LoanRepository {
    private CqlSession session;

    //constructor
    public LoanRepository(CqlSession session){
        this.session = session;
    }

    /* method gets all loans */
    public Flux<Loan> getAll(){
        return Flux.from(session.executeReactive("SELECT * FROM p2plender.loans"))
                                .map(row -> new Loan(row.getInt("loan_id"), row.getInt("lender_id"), row.getInt("borrower_id"), row.getDouble("interest_rate"), row.getDouble("loan_amount"), row.getString("loan_duration")));
    }

    /* method gets a single loan from loans */
    public Mono<Loan> get(int id){
        return Mono.from(session.executeReactive("SELECT * FROM p2plender.loans WHERE loan_id = " + id ))
                                .map(row -> new Loan(row.getInt("loan_id"), row.getInt("lender_id"), row.getInt("borrower_id"), row.getDouble("interest_rate"), row.getDouble("loan_amount"), row.getString("loan_duration")));
    }

    /* method gets loans specific to a borrower */
    public Flux<Loan> getUserLoans(int id){
            return Flux.from(session.executeReactive("SELECT * FROM p2plender.loans WHERE borrower_id = ? ALLOW FILTERING", id))
                                    .map(row -> new Loan(row.getInt("loan_id"), row.getInt("lender_id"), row.getInt("borrower_id"), row.getDouble("interest_rate"), row.getDouble("loan_amount"), row.getString("loan_duration")));
    }

    /* method  adds loan to database */
    public Loan create(Loan loan){
        SimpleStatement stm = SimpleStatement.builder("INSERT INTO p2plender.loans (loan_id, loan_amount, interest_rate, loan_duration, lender_id,borrower_id) VALUES (?,?,?,?,?,?)")
                                .addPositionalValues(loan.getLoanID(),loan.getLoanAmount(),loan.getInterestRate(),loan.getLoanDuration(),loan.getLenderId(),loan.getBorrowerId())
                                .build();
        Flux.from(session.executeReactive(stm)).subscribe();
        return loan;
    }

    /* removes a loan from database */
    public Mono<Loan> delete(int id){
        Mono.from(session.executeReactive("DELETE FROM p2plender.loans WHERE loan_id = ? IF loan_amount = 0", id)).subscribe();
        return  this.get(id);
    }

}