package com.navx.backend.service;

import com.navx.backend.model.Harassment;
import com.navx.backend.repository.HarassmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarassmentService {
    @Autowired
    private HarassmentRepository harassmentRepository;

    public ResponseEntity<?> createHarassment(Harassment harassment) {
        harassmentRepository.save(harassment);
        return new ResponseEntity<>("created Successfully", HttpStatus.OK);
    }

     public ResponseEntity<?> getHarassment(String bookingId) {
        List <Harassment> harassments = harassmentRepository.findAll();
        for (Harassment harassment : harassments) {
            if (harassment.getBookingId().equals(bookingId)) {
                return new ResponseEntity<>(harassment, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
     }

     public ResponseEntity<?> getAllHarassment(){
        return new ResponseEntity<>(harassmentRepository.findAll(), HttpStatus.OK);
     }
}
