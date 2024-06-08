package com.minimarvel.service.impl;

import com.minimarvel.model.dto.ServiceDTO;
import com.minimarvel.model.mapper.ServiceMapper;
import com.minimarvel.repository.ServicesRepository;
import com.minimarvel.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesImpl implements Services {
    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServiceMapper serviceMapper;


    @Override
    public void createService(ServiceDTO servicesDTO) {
        // Create a service from the serviceDTO
        // Save the service to the repository
        Services service = (Services) serviceMapper.toEntity(servicesDTO);
        servicesRepository.save(service);
    }

    @Override
    public void updateService(ServiceDTO servicesDTO) {

    }

    @Override
    public void deleteService(String id) {

    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return List.of();
    }
}
