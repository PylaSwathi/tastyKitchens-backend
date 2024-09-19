package com.ust.tastyKitchens.service;

import com.ust.tastyKitchens.model.Users;
import com.ust.tastyKitchens.repo.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    public CustomUserDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the database
        Users userEntity = (Users) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Convert Users entity to UserDetails
        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword()) // Password should be encrypted
                .authorities("USER") // Default authority if roles are not needed
                .build();
    }
}