package com.example.eindprojectbedc.repository;

import com.example.eindprojectbedc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
