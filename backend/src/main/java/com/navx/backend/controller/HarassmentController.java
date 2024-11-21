package com.navx.backend.controller;

import com.navx.backend.model.Harassment;
import com.navx.backend.service.HarassmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/vi/user/harassment")
public class HarassmentController {

    @Autowired
    HarassmentService harassmentService;

    @PostMapping()
    public ResponseEntity<?> createHarassment(Harassment harassment) {
        return harassmentService.createHarassment(harassment);
    }
    @GetMapping()
    public ResponseEntity<?> getAllHarassments() {
        return harassmentService.getAllHarassment();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getHarassmentById(@PathVariable String id) {
        return harassmentService.getHarassment(id);
    }
}
