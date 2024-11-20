package com.navx.backend.controller;

import com.navx.backend.model.Payment;
import com.navx.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity<?> newPayment(@RequestBody Payment payment) {
        return paymentService.newPayment(payment);
    }

    @GetMapping("/")
    public ResponseEntity<?> getALlPayments() {
        return paymentService.getAllPayments();
    }
}
