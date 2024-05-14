package com.lab3.controller;


import com.lab3.data.Student;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class home {

    @Autowired
    ServletContext context;
    @Autowired
    private CharacterEncodingFilter characterEncodingFilter;

    @GetMapping("form")
    public String home(@ModelAttribute("student") Student student) {
        return "form";
    }

    @PostMapping("save")
    public String result(@Validated @ModelAttribute("student") Student student, BindingResult result, @RequestParam("image") MultipartFile image, Model model) {
        characterEncodingFilter.setEncoding("UTF-8");
        // Kiểm tra dữ liệu nhập vào
        if (result.hasErrors()) {
            return "form";
        }
        else {
        if (image.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "form";
        } else {
            try {
                Path uploadDir = Paths.get("upload");
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }
                // Lưu trữ ảnh vào thư mục uploadDir
                String fileName = StringUtils.cleanPath(image.getOriginalFilename());
                Path path = uploadDir.resolve(fileName); // Sử dụng phương thức resolve để tạo đường dẫn tuyệt đối
                Files.write(path, image.getBytes());

                // Cập nhật đường dẫn ảnh vào đối tượng Student
                student.setAvatar(fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return "result";
        }
        }

    }

    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders() {
        Map<Boolean, String> genders = new HashMap<>();
        genders.put(true, "Male");
        genders.put(false, "Female");
        return genders;
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getHobbies() {
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("reading", "Reading");
        hobbies.put("music", "Music");
        hobbies.put("movie", "Movie");
        hobbies.put("travel", "Travel");
        hobbies.put("game", "Game");
        return hobbies;
    }

    @ModelAttribute("faculties")
    public List<String> getFaculty() {
        return Arrays.asList("Information Technology", "Business Administration", "Tourism", "Finance and Banking");
    }
}
