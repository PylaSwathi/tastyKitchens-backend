package com.ust.tastyKitchens.repo;

import com.ust.tastyKitchens.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Object> findByUsername(String username);
}
