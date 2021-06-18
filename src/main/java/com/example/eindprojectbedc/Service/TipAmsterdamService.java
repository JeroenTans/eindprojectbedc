package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.model.TipAmsterdam;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TipAmsterdamService {

    List<TipAmsterdam> getAllTipsAmsterdam();

    TipAmsterdam getTipAmsterdam(Long id);

    TipAmsterdam saveTipAmsterdam(TipAmsterdam tipAmsterdam);

    void deleteTipAmsterdam(Long id);

    void addTipAmsterdam(TipAmsterdam tipAmsterdam);

    Resource downloadFile(Long id);

//    void uploadPicturePath(Long id, MultipartFile picturePath) throws IOException;

//    byte[] getPicturePath(Long id);


}
