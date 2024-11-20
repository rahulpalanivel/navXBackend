package com.navx.backend.controller;

import com.navx.backend.model.Contact;
import com.navx.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/")
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllContact() {
        return contactService.getContact();
    }
}
