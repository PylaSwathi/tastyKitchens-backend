package com.ust.tastyKitchens.controller;

import com.ust.tastyKitchens.service.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        try {
            String token = usersService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
            System.out.println("user"+ loginRequest.getUsername());
            Cookie cookie = new Cookie("jwt_token", token);
            cookie.setHttpOnly(true);
             // Set to true if you're using HTTPS
            cookie.setPath("/");
            response.addCookie(cookie);
            return ResponseEntity.ok().body("Login successful");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


    // Internal class to capture login request body
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
