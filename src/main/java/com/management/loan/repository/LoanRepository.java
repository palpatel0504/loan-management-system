package com.management.loan.repository;

import com.management.loan.entity.Loan;
import com.management.loan.entity.User;
import com.management.loan.enums.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    List<Loan> findByCustomer(User customer);
    List<Loan> findByOfficer(User officer);
    List<Loan> findByStatus(LoanStatus status);
    Long countByStatus(LoanStatus status);

}
