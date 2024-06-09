package com.minimarvel.service;

import com.minimarvel.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    void updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
    UserDTO login(String username, String password);
    UserDTO getUserByIdF(Long id);
}
