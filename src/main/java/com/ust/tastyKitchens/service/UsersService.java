package com.ust.tastyKitchens.service;

import com.ust.tastyKitchens.config.JwtTokenProvider;
import com.ust.tastyKitchens.model.Users;
import com.ust.tastyKitchens.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    public String loginUser(String username, String password) {
        Users user = (Users) userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtTokenProvider.generateToken(username);
    }
}
