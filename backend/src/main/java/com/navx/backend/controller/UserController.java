package com.navx.backend.controller;


import com.navx.backend.Auth.SignupRequest;
import com.navx.backend.model.User;
import com.navx.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user")
public class  UserController {

    @Autowired
    private UserService userService;

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        return userService.getAllUsers();
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody SignupRequest user) {
        System.out.println(user.getEmail());
//        return new ResponseEntity<>("Welcome" ,HttpStatus.OK);
        return userService.updateUsers(user);
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        return  userService.getUserByEmail(email);
    }
}
