package com.navx.backend.controller;


import com.navx.backend.model.Booking;
import com.navx.backend.service.BookingService;
import com.navx.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping()
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping()
    public ResponseEntity<?> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooking(@PathVariable String id) {
        return bookingService.getBookings(id);
    }

//    @DeleteMapping("/")
//    public ResponseEntity<?> deleteBooking(){}
//    public ResponseEntity<?> updateBooking(){}

}
