package com.management.loan.entity;

import com.management.loan.enums.LoanStatus;
import com.management.loan.enums.LoanType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private BigDecimal loanAmount;
    private Integer tenureMonths;
    private Double interestRate;
    private String purpose;

    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private String remarks;
    private LocalDateTime appliedAt;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name="officer_id")
    private User officer;

}
