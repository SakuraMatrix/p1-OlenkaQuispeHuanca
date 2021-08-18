package com.github.olenkaqh.p1.service;

import com.github.olenkaqh.p1.domain.Loan;
import com.github.olenkaqh.p1.repository.LoanRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class LoanService {
    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    public Flux<Loan> getAll() {
        return loanRepository.getAll();
    }

//    public Flux<Loan> getBorrowerLoans(String id) {
//        return loanRepository.getBorrowerLoans(Integer.parseInt(id));
//    }

    public Mono<Loan> get(String id) {
        return loanRepository.get(Integer.parseInt(id));
    }
    public Loan addLoan(Loan loan) {
        return loanRepository.create(loan);
    }
}
