package com.navx.backend.repository;

import com.navx.backend.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends MongoRepository<User, String> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    @NotNull Optional<User> findById(@NotNull String id);

}
