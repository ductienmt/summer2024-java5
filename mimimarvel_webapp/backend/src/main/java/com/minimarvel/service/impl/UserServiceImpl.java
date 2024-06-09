package com.minimarvel.service.impl;

import com.minimarvel.entity.User;
import com.minimarvel.model.dto.UserDTO;
import com.minimarvel.model.mapper.UserMapper;
import com.minimarvel.repository.UserRepository;
import com.minimarvel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public void createUser(UserDTO userDTO) {
        // Create a user from the userDTO
        // Save the user to the repository
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        // Find the user by id
        // Update the user with the new userDTO
        // Save the user to the repository
        User user = getUserById(id);
        if(user != null) {
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setFullname(userDTO.getFullname());
            user.setAvatar(userDTO.getAvatar());
            user.setBirthdate(userDTO.getBirthdate());
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        // Find the user by id
        // Delete the user from the repository
        if(this.getUserById(id) != null) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // Get list of users from repository
        // Convert the list of users to a list of userDTOs
        // Return the list of userDTOs
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO login(String username, String password) {
        // Find the user by username
        // If the user is found and the password matches, return the userDTO
        // Otherwise, return null
        User user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            return userMapper.toDTO(user);
        }
        return null;
    }

    @Override
    public UserDTO getUserByIdF(Long id) {
        return userMapper.toDTO(getUserById(id));
    }

    private User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
