package com.navx.backend.controller;


import com.navx.backend.Auth.LoginRequest;
import com.navx.backend.Auth.SignupRequest;
import com.navx.backend.model.User;
import com.navx.backend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/auth")
public class  AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public ResponseEntity<?> get() {
        return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        return authService.registerUser(signupRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }


}
