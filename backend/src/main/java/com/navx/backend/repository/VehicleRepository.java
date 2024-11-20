package com.navx.backend.repository;

import com.navx.backend.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
