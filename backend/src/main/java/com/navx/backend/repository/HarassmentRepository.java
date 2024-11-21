package com.navx.backend.repository;

import com.navx.backend.model.Harassment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HarassmentRepository  extends MongoRepository<Harassment, String> {
    @Override
    @NotNull
    Optional<Harassment> findById(@NotNull String id);
}
