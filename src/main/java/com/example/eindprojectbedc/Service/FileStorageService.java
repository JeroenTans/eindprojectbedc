package com.example.eindprojectbedc.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void uploadFile(MultipartFile picturePath);
}
