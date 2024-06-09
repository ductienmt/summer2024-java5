package com.minimarvel.service;

import com.minimarvel.model.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void login (String username, String password);
    void register(AdminDTO adminDTO);
    void update(AdminDTO adminDTO);
    void delete(String username);
    List<AdminDTO> getAll();
}
