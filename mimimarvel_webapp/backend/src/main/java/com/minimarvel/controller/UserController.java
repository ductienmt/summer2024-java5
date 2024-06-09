package com.minimarvel.controller;


import com.minimarvel.model.dto.UserDTO;
import com.minimarvel.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("list")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all users failed " + e.getMessage());
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUserByIdF(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get user failed " + e.getMessage());
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            UserDTO userDTO = userService.login(username, password);

            return ResponseEntity.ok(userDTO);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Login failed "+ e.getMessage());
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        try {
            userService.createUser(userDTO);
            return ResponseEntity.ok("Create user success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create user failed "+ e.getMessage());
        }
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try {
            userService.updateUser(id, userDTO);
            return ResponseEntity.ok("Update user success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update user failed "+ e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Delete user success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete user failed "+ e.getMessage());
        }
    }
}
