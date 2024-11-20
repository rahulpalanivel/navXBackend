package com.navx.backend.repository;

import com.navx.backend.model.Shared;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SharedRepository extends MongoRepository<Shared, String> {
    @NotNull Optional<Shared> findById(@NotNull String id);
}
