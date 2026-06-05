package com.management.loan.service;

import com.management.loan.dto.LoanRequest;
import com.management.loan.dto.LoanResponse;

public interface LoanService {
    LoanResponse applyLoan(LoanRequest request);
}
