package com.example.eindprojectbedc.server.repository;

import com.example.eindprojectbedc.server.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    String getAuthorityByUsername(String username);
}
