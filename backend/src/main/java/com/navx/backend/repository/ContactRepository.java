package com.navx.backend.repository;

import com.navx.backend.model.Contact;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ContactRepository extends MongoRepository<Contact, String> {
    @Override
    @NotNull
    Optional<Contact> findById(@NotNull String id);
}
