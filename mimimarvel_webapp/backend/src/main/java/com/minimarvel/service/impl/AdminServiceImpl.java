package com.minimarvel.service.impl;

import com.minimarvel.entity.Admin;
import com.minimarvel.model.dto.AdminDTO;
import com.minimarvel.model.mapper.AdminMapper;
import com.minimarvel.repository.AdminRepository;
import com.minimarvel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public void login(String username, String password) {
        //check username and password not null
        if (username != null || password != null) {
            Admin admin = adminRepository.findById(username).orElse(null);
            if (admin != null) {
                //check password
                if (admin.getPassword().equals(password)) {
                    System.out.println("Login success");
                } else {
                    System.out.println("Login failed");
                }
            }
        }
    }

    @Override
    public void register(AdminDTO adminDTO) {
        Admin admin = adminMapper.toEntity(adminDTO);
        adminRepository.save(admin);
    }

    @Override
    public void update(AdminDTO adminDTO) {
        Admin admin = adminMapper.toEntity(adminDTO);
        adminRepository.save(admin);
    }

    @Override
    public void delete(String username) {
        adminRepository.deleteById(username);
    }

    @Override
    public List<AdminDTO> getAll() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(adminMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AdminDTO getAdminByUsername(String username) {
        Admin admin = adminRepository.findById(username).orElse(null);
        return adminMapper.toDTO(admin);
    }
}
