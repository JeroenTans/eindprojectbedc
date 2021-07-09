package com.example.eindprojectbedc.repository;

import com.example.eindprojectbedc.model.Authority;
import com.example.eindprojectbedc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findUserByGroupName(String groupName);
}
