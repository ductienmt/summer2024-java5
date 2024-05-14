package com.lab3_html.controller;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/student/getimg/{avt}")
public class img_upload_controler {
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("avt") String avt) {
        if (!avt.isEmpty()) {
            try {
                Path path = Paths.get("upload", avt);
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
