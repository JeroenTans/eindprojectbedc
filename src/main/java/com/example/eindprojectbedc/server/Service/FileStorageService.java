package com.example.eindprojectbedc.server.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {

    void uploadFile(MultipartFile picturePath);
    void deleteFile(String filename) throws IOException;
}
