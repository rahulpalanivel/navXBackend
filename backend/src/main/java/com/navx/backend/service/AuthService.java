package com.navx.backend.service;

import com.navx.backend.Auth.LoginRequest;
import com.navx.backend.Auth.LoginResponse;
import com.navx.backend.Auth.SignupRequest;
import com.navx.backend.Auth.SignupResponse;
import com.navx.backend.config.UserDetailsImpl;
import com.navx.backend.jwt.JwtUtils;
import com.navx.backend.model.RoleTypes;
import com.navx.backend.model.User;
import com.navx.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.*;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity<?> registerUser(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return new ResponseEntity<>(new SignupResponse("User already exist"), HttpStatus.ALREADY_REPORTED);
        }

        User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()), signupRequest.getPhoneno(),
                signupRequest.getAddress(), signupRequest.getGender(), signupRequest.getRoles());

        Set<RoleTypes> strRoles = signupRequest.getRoles();
        Set<RoleTypes> roles = new HashSet<>();

        if (strRoles == null) {
            roles.add(RoleTypes.ROLE_USER);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case RoleTypes.ROLE_ADMIN:
                        roles.add(RoleTypes.ROLE_ADMIN);
                        break;
                    case RoleTypes.ROLE_DRIVER:
                        roles.add(RoleTypes.ROLE_DRIVER);
                        break;
                    default:
                        roles.add(RoleTypes.ROLE_USER);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity<>(new SignupResponse("User registered successfully!"), HttpStatus.OK);
    }

    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails, userDetails.getId(), roles);

        LoginResponse response = new LoginResponse();
        response.setEmail(userDetails.getEmail());
        response.setUsername(userDetails.getUsername());
        response.setPhoneno(userDetails.getPhoneno());
        response.setAddress(userDetails.getAddress());
        response.setJwtToken(jwtToken);
        response.setRoles(roles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
