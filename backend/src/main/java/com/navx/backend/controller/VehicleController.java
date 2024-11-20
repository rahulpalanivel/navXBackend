package com.navx.backend.controller;

import com.navx.backend.model.Vehicle;
import com.navx.backend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<?> registerVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.registerVehicle(vehicle);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> getVehicle(@PathVariable String userId) {
        return vehicleService.getVehicle(userId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}
