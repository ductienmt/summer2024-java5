package com.minimarvel.service;

import com.minimarvel.model.dto.ServiceDTO;

import java.util.List;

public interface Services {
    void createService(ServiceDTO servicesDTO);
    void updateService(ServiceDTO servicesDTO);
    void deleteService(String id);
    List<ServiceDTO> getAllServices();
}
