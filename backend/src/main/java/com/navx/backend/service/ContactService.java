package com.navx.backend.service;

import com.navx.backend.model.Booking;
import com.navx.backend.model.Contact;
import com.navx.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public ResponseEntity<?> createContact(Contact contact) {
        contactRepository.save(contact);
        return new ResponseEntity<>("Contact Success", HttpStatus.OK);
    }

    public ResponseEntity<?> updateContact(Contact contact) {
        if(contactRepository.findById(contact.getId()).isEmpty()){
            return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
        }
        Contact oldContact = contactRepository.findById(contact.getId()).get();
        oldContact.setStatus(contact.getStatus());
        contactRepository.save(oldContact);
        return new ResponseEntity<>("Contact update Success", HttpStatus.OK);
    }

    public ResponseEntity<?> getContact() {
        return new ResponseEntity<>(contactRepository.findAll(), HttpStatus.OK);
    }

}
