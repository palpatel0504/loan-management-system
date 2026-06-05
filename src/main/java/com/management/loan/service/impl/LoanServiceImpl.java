package com.management.loan.service.impl;


import com.management.loan.LoanApplication;
import com.management.loan.dto.LoanRequest;
import com.management.loan.dto.LoanResponse;
import com.management.loan.entity.Loan;
import com.management.loan.entity.User;
import com.management.loan.enums.LoanStatus;
import com.management.loan.repository.LoanRepository;
import com.management.loan.repository.UserRepository;
import com.management.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;

    @Override
    public LoanResponse applyLoan(LoanRequest request){
        User customer = userRepository.findById(1L)
                .orElseThrow();

        Loan loan = Loan.builder()
                .loanAmount(request.getLoanAmount())
                .tenureMonths(request.getTenureMonths())
                .purpose(request.getPurpose())
                .loanType(request.getLoanType())
                .status(LoanStatus.PENDING)
                .customer(customer)
                .appliedAt(LocalDateTime.now())
                .build();
        Loan savedLoan = loanRepository.save(loan);

        return LoanResponse.builder()
                .id(savedLoan.getId())
                .loanAmount(savedLoan.getLoanAmount())
                .tenureMonths(request.getTenureMonths())
                .loanType(savedLoan.getLoanType())
                .status(savedLoan.getStatus())
                .purpose(savedLoan.getPurpose())
                .build();


    }
}
