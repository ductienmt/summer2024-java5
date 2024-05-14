package com.lab3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/img/{imageName}")
public class img_controller {
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("imageName") String image) {
        if (!image.isEmpty()) {
            try {
                Path path = Paths.get("upload", image);
                byte[] data = Files.readAllBytes(path);
                return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(data);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

}
