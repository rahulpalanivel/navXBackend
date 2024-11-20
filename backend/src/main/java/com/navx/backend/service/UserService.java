package com.navx.backend.service;

import com.navx.backend.Auth.SignupRequest;
import com.navx.backend.model.User;
import com.navx.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> updateUsers(SignupRequest user){
        if(userRepository.findByEmail(user.getEmail()).isEmpty()){
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
        User oldUser = userRepository.findByEmail(user.getEmail()).get();
        oldUser.setAddress(user.getAddress());
        oldUser.setEmail(user.getEmail());
        oldUser.setGender(user.getGender());
        oldUser.setRoles(user.getRoles());
        oldUser.setPhoneno(user.getPhoneno());
        oldUser.setUsername(user.getUsername());
        userRepository.save(oldUser);
        return new ResponseEntity<>("User update success", HttpStatus.OK);
    }

    public ResponseEntity<Optional<User>> getUserByEmail(String email){
        return new ResponseEntity<>(userRepository.findByEmail(email), HttpStatus.OK);
    }
}
