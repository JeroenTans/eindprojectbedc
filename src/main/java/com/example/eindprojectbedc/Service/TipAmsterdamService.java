package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.model.TipAmsterdam;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TipAmsterdamService {

    List<TipAmsterdam> getAllTipsAmsterdam();

    TipAmsterdam getTipAmsterdam(Long id);

    Optional<TipAmsterdam> getTipAmsterdamById(Long id);

    void deleteTipAmsterdam(Long id);

    void addTipAmsterdam(TipAmsterdam tipAmsterdam);

    Resource downloadFile(Long id);

//    List<TipAmsterdam> getAllPublicTipsAmsterdam();

}

//    TipAmsterdam saveTipAmsterdam(TipAmsterdam tipAmsterdam);
