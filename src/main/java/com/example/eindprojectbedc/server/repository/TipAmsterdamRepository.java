package com.example.eindprojectbedc.server.repository;

import com.example.eindprojectbedc.server.model.TipAmsterdam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipAmsterdamRepository extends JpaRepository<TipAmsterdam, Long> {
    TipAmsterdam findTipAmsterdamById (Long id);
    List<TipAmsterdam> findTipAmsterdamsByUsername(String username);
    List<TipAmsterdam> findTipAmsterdamBySendTipTrueAndUsername(String username);
    List<TipAmsterdam> findTipAmsterdamByReceivedTipTrueAndUsername(String username);
    List<TipAmsterdam> findTipAmsterdamByGroupName(String groupName);
}
