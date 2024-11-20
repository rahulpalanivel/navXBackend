package com.navx.backend.service;

import com.navx.backend.model.Payment;
import com.navx.backend.model.Vehicle;
import com.navx.backend.repository.PaymentRepository;
import com.navx.backend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public ResponseEntity<?> registerVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return new ResponseEntity<>("Vehicle Registered successfully", HttpStatus.OK);
    }

    public ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getVehicle(String userId) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        for(Vehicle vehicle : vehicles) {
            if(vehicle.getOwnerId().equals(userId)) {
                return new ResponseEntity<>(vehicle, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("vehicle not Found", HttpStatus.NOT_FOUND);
    }

}
