package com.minimarvel.model.mapper;


import com.minimarvel.entity.Admin;
import com.minimarvel.model.dto.AdminDTO;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    // Convert Admin to AdminDTO
    public AdminDTO toDTO(Admin admin) {
        if (admin == null) {
            return null;
        }
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setPassword(admin.getPassword());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setFullname(admin.getFullname());
        return adminDTO;
    }

    // Convert AdminDTO to Admin
    public Admin toEntity(AdminDTO adminDTO) {
        if (adminDTO == null) {
            return null;
        }
        Admin admin = new Admin();
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());
        admin.setFullname(adminDTO.getFullname());
        return admin;
    }

}
