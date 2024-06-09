package com.minimarvel.service;

import com.minimarvel.model.dto.ServiceDTO;

import java.util.List;

public interface ServicesService {
    void createService(ServiceDTO servicesDTO);
    void updateService(String id, ServiceDTO servicesDTO);
    void deleteService(String id);
    List<ServiceDTO> getAllServices();
}
