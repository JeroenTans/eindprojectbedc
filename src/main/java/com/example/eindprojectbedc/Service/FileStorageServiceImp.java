package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.exception.FileStorageException;

import com.example.eindprojectbedc.model.TipAmsterdam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class FileStorageServiceImp implements FileStorageService{

//    @Value("${app.upload.dir:${user.home}}")
//
//    private final Path picturePathStorageLocation = Paths.get("uploads");
//    @Value("${app.upload.dir:${user.home}}")
//    private String uploadDirectory;  // relative to root
//    private final String picturePathStorageLocation = "C:/Users/Jeroen Tans/Novi/IntellijProjects/Basic.Programming/eindprojectbedc/uploads";

    @Value("${app.upload.dir:${user.home}}")
    private String uploadDirectory;  // relative to root
    private final Path uploads = Paths.get("./uploads");


    @Override
    public void uploadFile(MultipartFile picturePath) {
        try {
            Path copyLocation = Paths.get(uploads + File.separator + StringUtils.cleanPath(picturePath.getOriginalFilename()));
            Files.copy(picturePath.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + picturePath.getOriginalFilename() + ". Please try again.");
        }
    }

    @Override
    public void deleteFile(String filename) throws IOException {
        Path deleteLocation = Paths.get(uploads + File.separator + StringUtils.cleanPath(filename));
        Files.delete(deleteLocation);
    }
}
