package com.navx.backend.service;

import com.navx.backend.model.Booking;
import com.navx.backend.model.Shared;
import com.navx.backend.repository.SharedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SharedService {
    @Autowired
    private SharedRepository sharedRepository;

    public ResponseEntity<?> createShared(Shared shared) {
        sharedRepository.save(shared);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<?> getAllShared(){
        return new ResponseEntity<>(sharedRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getShared(String Id){
        return new ResponseEntity<>(sharedRepository.findById(Id), HttpStatus.OK);
    }

}
