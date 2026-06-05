package com.management.loan.controller;


import com.management.loan.dto.LoanRequest;
import com.management.loan.dto.LoanResponse;
import com.management.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    public LoanResponse applyLoan(
            @RequestBody LoanRequest request){
        return loanService.applyLoan(request);

    }

}
