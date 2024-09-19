package com.ust.tastyKitchens.controller;

import com.ust.tastyKitchens.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final JwtUtil jwtUtil = new JwtUtil(); // You can also inject it if you prefer

    @GetMapping("/parse-token")
    public ResponseEntity<?> parseToken(@RequestParam String token) {
        try {
            Claims claims = jwtUtil.parseToken(token);
            return ResponseEntity.ok(claims);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
}

