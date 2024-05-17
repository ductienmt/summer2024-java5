package com.lab4.controller;

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
@RequestMapping("/img/{avt}")
public class upload_img_controller {
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("avt") String avt) {
        if (!avt.isEmpty()) {
            try {
                Path path = Paths.get("uploads", avt);
                byte[] data = Files.readAllBytes(path);
                return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(data);
            } catch (Exception e) {
                System.out.println("Lỗi đọc file");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

}
