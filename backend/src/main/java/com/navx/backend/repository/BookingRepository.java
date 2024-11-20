package com.navx.backend.repository;

import com.navx.backend.model.Booking;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends MongoRepository<Booking, String> {
    @NotNull Optional<Booking> findById(@NotNull String Id);
}
