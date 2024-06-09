package com.minimarvel.controller.admin;


import com.minimarvel.model.dto.AdminDTO;
import com.minimarvel.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminDTO adminDTO) {
        try {
            adminService.login(adminDTO.getUsername(), adminDTO.getPassword());
            return ResponseEntity.ok("Login success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AdminDTO adminDTO) {
        try {
            adminService.register(adminDTO);
            return ResponseEntity.ok("Register success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Register failed");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody AdminDTO adminDTO) {
        try {
            adminService.update(adminDTO);
            return ResponseEntity.ok("Update success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update failed");
        }
    }

    @PostMapping("/delete/{username}")
    public ResponseEntity<?> delete(@PathVariable String username) {
        try {
            adminService.delete(username);
            return ResponseEntity.ok("Delete success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete failed");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(adminService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all failed");
        }
    }

    @GetMapping("/getAdminByUsername/{username}")
    public ResponseEntity<?> getAdminByUsername(@PathVariable String username) {
        try {
            return ResponseEntity.ok(adminService.getAdminByUsername(username));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get admin by username failed");
        }
    }

}
