package com.management.loan.dto;

import com.management.loan.enums.LoanType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanRequest {
    private BigDecimal loanAmount;
    private Integer tenureMonths;
    private String purpose;
    private LoanType loanType;
}
