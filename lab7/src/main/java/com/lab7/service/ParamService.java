package com.lab7.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest res;

    public File save(MultipartFile file, String path) {
        // Check if the file is empty
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty: " + file.getOriginalFilename());
        }

        try {
            // Get the original filename
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new RuntimeException("Original filename is null");
            }

            // Create the directory if it does not exist
            Path directoryPath = Paths.get(path).toAbsolutePath().normalize();
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            // Create the file path
            Path filePath = directoryPath.resolve(originalFilename);

            // Save the file to the target location
            file.transferTo(filePath.toFile());

            System.out.println("File saved successfully: " + filePath);

            // Return the saved file
            return filePath.toFile();
        } catch (IOException ex) {
            throw new RuntimeException("Could not save file: " + file.getOriginalFilename() + " due to: " + ex.getMessage(), ex);
        }
    }
}
