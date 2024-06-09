package com.minimarvel.model.mapper;

import com.minimarvel.entity.User;
import com.minimarvel.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setPhone(user.getPhone());
        userDTO.setFullname(user.getFullname());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setBirthdate(user.getBirthdate());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());
        user.setPhone(userDTO.getPhone());
        user.setFullname(userDTO.getFullname());
        user.setAvatar(userDTO.getAvatar());
        user.setBirthdate(userDTO.getBirthdate());
        return user;
    }
}
