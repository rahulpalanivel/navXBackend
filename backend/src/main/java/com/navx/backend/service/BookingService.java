package com.navx.backend.service;

import com.navx.backend.model.Booking;

import com.navx.backend.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public ResponseEntity<?> createBooking(Booking booking) {
        Booking booked = bookingRepository.save(booking);
        Map<String, Object> response = new HashMap<>();
        response.put("id", booked.getId());
        response.put("message", "Booking Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getBookings(String Id){
        return new ResponseEntity<>(bookingRepository.findById(Id), HttpStatus.OK);
    }
}
