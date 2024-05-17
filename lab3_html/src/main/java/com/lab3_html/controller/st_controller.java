package com.lab3_html.controller;


import com.lab3_html.data.Student;
import jakarta.validation.Valid;
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
@RequestMapping("/student")
public class st_controller {

    private final CharacterEncodingFilter characterEncodingFilter;

    public st_controller(CharacterEncodingFilter characterEncodingFilter) {
        this.characterEncodingFilter = characterEncodingFilter;
    }

    @GetMapping("form")
    public String form(@ModelAttribute("sv") Student student) {
        return "views/form_page";
    }

    @PostMapping("save")
    public StcharacterEncodingFilter.setEncoding("UTF-8");
        if (result.hasErrors()) {ring save(@Validated @ModelAttribute("sv") Student student, BindingResult result, @RequestParam("avt") MultipartFile avatar, Model model) {

            return "views/form_page";
        }
        else {
            if (avatar.isEmpty()) {
                model.addAttribute("message", "Please select a file to upload");
                return "views/form_page";
            }
            else {
                try {
                    Path uploadDir = Paths.get("upload");
                    if (!Files.exists(uploadDir)) {
                        Files.createDirectories(uploadDir);
                    }
                    // Lưu trữ ảnh vào thư mục uploadDir
                    String fileName = StringUtils.cleanPath(avatar.getOriginalFilename());
                    Path path = uploadDir.resolve(fileName); // Sử dụng phương thức resolve để tạo đường dẫn tuyệt đối
                    Files.write(path, avatar.getBytes());
//            System.out.println(path);
//            System.out.println(fileName);

                    // Cập nhật đường dẫn ảnh vào đối tượng Student
                    student.setAvatar(fileName);
//            System.out.println(student.getAvatar());

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "views/result_page";
            }
        }
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getHobbies() {
        Map<String, String> hobbies = new HashMap<>();
        hobbies.put("1", "Reading");
        hobbies.put("2", "Music");
        hobbies.put("3", "Sport");
        hobbies.put("4", "Travel");
        hobbies.put("5", "Game");
        return hobbies;
    }

    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders() {
        Map<Boolean, String> genders = new HashMap<>();
        genders.put(true, "Male");
        genders.put(false, "Female");
        return genders;
    }

    @ModelAttribute("faculties")
    public List<String> getFaculties() {
        return Arrays.asList("Sofware Engineering", "AI Engineer", "Full Stack", "Mobile Developer", "Web Developer",
                            "Network Engineer", "System Engineer", "Data Engineer", "Data Scientist", "Cloud Engineer");
    }


}
