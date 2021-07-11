package com.example.eindprojectbedc.repository;

import com.example.eindprojectbedc.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    String getAuthorityByUsername(String username);
}
