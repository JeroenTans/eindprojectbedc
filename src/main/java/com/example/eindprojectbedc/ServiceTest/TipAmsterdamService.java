package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.model.TipAmsterdam;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Optional;

public interface TipAmsterdamService {

    List<TipAmsterdam> getAllTipsAmsterdam();

    TipAmsterdam getTipAmsterdam(Long id);

    Optional<TipAmsterdam> getTipAmsterdamById(Long id);

    void deleteTipAmsterdam(Long id);

    TipAmsterdam addTipAmsterdam(TipAmsterdam tipAmsterdam);

    void addTipAmsterdamAdmin(TipAmsterdam tipAmsterdam);

    Resource downloadFile(Long id);

    List<Object> getAllPublicTipsAmsterdam();

    List<Object> getAllPrivateTipsAmsterdam();

    List<Object> getAllStandardTipsAmsterdam();

    List<Object> getAllPrivateTipsAmsterdamByUsername(String username);

    List<Object> getAllPublicTipsAmsterdamByUsername(String username);

}

