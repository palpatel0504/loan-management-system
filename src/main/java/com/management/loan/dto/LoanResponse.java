package com.management.loan.dto;


import com.management.loan.enums.LoanStatus;
import com.management.loan.enums.LoanType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LoanResponse {
    private Long id;
    private BigDecimal loanAmount;
    private Integer tenureMonths;
    private LoanType loanType;
    private LoanStatus status;
    private String purpose;
}
