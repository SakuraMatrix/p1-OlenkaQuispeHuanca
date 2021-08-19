package com.github.olenkaqh.p1.service;

import com.github.olenkaqh.p1.domain.Loan;
import com.github.olenkaqh.p1.repository.LoanRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class LoanService {
    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }
    public Flux<Loan> getAll() {
        return loanRepository.getAll();
    }
    public Flux<Loan> getUserLoans(String id) {
        return loanRepository.getUserLoans(Integer.parseInt(id));
    }
    public Mono<Loan> get(String id) {
        return loanRepository.get(Integer.parseInt(id));
    }
    public Loan addLoan(Loan loan) {
        return loanRepository.create(loan);
    }
    public Mono<Loan> remove(String id) {
        return loanRepository.delete(Integer.parseInt(id));
    }
}
