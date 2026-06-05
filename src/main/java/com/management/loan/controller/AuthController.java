package com.management.loan.controller;

import com.management.loan.dto.LoginRequest;
import com.management.loan.dto.RegisterRequest;
import com.management.loan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request){
        return authService.login(request);
    }
}
