package com.navx.backend.controller;


import com.navx.backend.model.Shared;
import com.navx.backend.service.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user/shared")
public class SharedController {
    @Autowired
    private SharedService sharedService;

    @PostMapping("/")
    public ResponseEntity<?> createShared(@RequestBody Shared shared) {
        return sharedService.createShared(shared);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllShared() {
        return sharedService.getAllShared();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShared(@PathVariable String id) {
        return sharedService.getShared(id);
    }
}


