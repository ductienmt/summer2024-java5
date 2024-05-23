package com.minimarvel.controler.user;

import com.minimarvel.entity.Users;
import com.minimarvel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("register")
    public Users register(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @GetMapping("list")
    public List<Users> getList() {
        return userRepository.findAll();
    }
}
