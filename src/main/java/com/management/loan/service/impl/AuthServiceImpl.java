package com.management.loan.service.impl;

import com.management.loan.dto.LoginRequest;
import com.management.loan.dto.RegisterRequest;
import com.management.loan.entity.User;
import com.management.loan.enums.Role;
import com.management.loan.repository.UserRepository;
import com.management.loan.security.JwtService;
import com.management.loan.service.AuthService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String register(RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("email already exists");
        }
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(Role.CUSTOMER)
                .createdAt(LocalDateTime.now())
                .build();
        userRepository.save(user);
        return "user registered successfully";
    }

    @Override
    public String login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new RuntimeException("user not found"));
        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()

        )){
            throw new RuntimeException("invalid credentials");
        }
        return jwtService.generateToken(user.getEmail());
    }

}
