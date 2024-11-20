package com.navx.backend.service;

import com.navx.backend.model.Payment;
import com.navx.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public ResponseEntity<?> newPayment(Payment payment) {
        paymentRepository.save(payment);
        return new ResponseEntity<>("Payment completed successfully", HttpStatus.OK);
    }

    public ResponseEntity<?> getAllPayments() {
        return new ResponseEntity<>(paymentRepository.findAll(), HttpStatus.OK);
    }
}
