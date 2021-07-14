package com.example.eindprojectbedc.server.repository;

import com.example.eindprojectbedc.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findUserByGroupName(String groupName);
}
