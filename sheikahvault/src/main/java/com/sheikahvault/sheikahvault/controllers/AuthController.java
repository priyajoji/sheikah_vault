package com.sheikahvault.sheikahvault.controllers;

import com.sheikahvault.sheikahvault.dto.LoginRequest;
import com.sheikahvault.sheikahvault.dto.SignupRequest;
import com.sheikahvault.sheikahvault.services.UserService;
import com.sheikahvault.sheikahvault.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@RequestBody SignupRequest request) {
        try {
            service.registerUser(request.getEmail(), request.getPassword());
            return "User registered";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        service.loginUser(request.getEmail(), request.getPassword());

        String token = jwtUtil.generateToken(request.getEmail());

        return token;
    }

}
