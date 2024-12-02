package com.acmeplex.controller;

import com.acmeplex.model.RegisteredUser;
import com.acmeplex.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private RegisteredUserService registeredUserService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegisteredUser user) {
        boolean isAuthenticated = registeredUserService.authenticateUser(user.getEmail(), user.getPassword());
        return isAuthenticated ? ResponseEntity.ok("Login Successful") : ResponseEntity.status(401).body("Invalid Credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisteredUser user) {
        RegisteredUser newUser = registeredUserService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }
}
