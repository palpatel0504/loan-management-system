package com.management.loan.service;

import com.management.loan.dto.LoginRequest;
import com.management.loan.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest request);

    String login(LoginRequest request);
}
