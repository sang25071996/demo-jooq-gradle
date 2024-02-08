package com.demo.controller;

import com.demo.dto.RequestChangePassword;
import com.demo.dto.UserRegister;
import com.demo.service.AuthService;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Boolean> register(@RequestBody UserRegister userRegister) throws FirebaseAuthException, GeneralSecurityException {
        return new ResponseEntity<>(authService.register(userRegister), HttpStatus.OK);
    }

    @GetMapping("/verify-login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<FirebaseToken> verify(@RequestParam String idToken) {
        return new ResponseEntity<>(authService.verify(idToken), HttpStatus.OK);
    }

    @PostMapping("/change-password")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Boolean> changePassword(@RequestBody RequestChangePassword json) {
        return new ResponseEntity<>(authService.changePassword(json), HttpStatus.OK);
    }
}
