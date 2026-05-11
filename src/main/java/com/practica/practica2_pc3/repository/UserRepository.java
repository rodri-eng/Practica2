package com.practica.practica2_pc3.repository;

import com.practica.practica2_pc3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);

    Optional<User> findByUsername(String username);
}
