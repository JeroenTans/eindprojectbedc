package com.example.eindprojectbedc.repository;

import com.example.eindprojectbedc.model.TipAmsterdam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipAmsterdamRepository extends JpaRepository<TipAmsterdam, Long> {
//    List<TipAmsterdam> findByPublicTipIsTrue();
}
