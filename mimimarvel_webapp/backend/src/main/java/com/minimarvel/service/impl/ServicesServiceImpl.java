package com.minimarvel.service.impl;

import com.minimarvel.entity.Services;
import com.minimarvel.model.dto.ServiceDTO;
import com.minimarvel.model.mapper.ServiceMapper;
import com.minimarvel.repository.ServicesRepository;
import com.minimarvel.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServiceMapper serviceMapper;


    @Override
    public void createService(ServiceDTO servicesDTO) {
        // Create a service from the serviceDTO
        // Save the service to the repository
        Services service = serviceMapper.toEntity(servicesDTO);
        servicesRepository.save(service);
    }

    @Override
    public void updateService(String id, ServiceDTO servicesDTO) {
        // Find the service by id
        // Update the service with the new serviceDTO
        // Save the service to the repository
        Services service = this.getServiceById(id);
        if(service != null) {
            service.setName(servicesDTO.getName());
            service.setDescription(servicesDTO.getDescription());
            service.setImage(servicesDTO.getImage());
            service.setStatus(servicesDTO.getStatus());
            service.setPrice(servicesDTO.getPrice());
            servicesRepository.save(service);
        }
    }

    @Override
    public void deleteService(String id) {
        // Find the service by id
        // Delete the service from the repository
        if(this.getServiceById(id) != null) {
            servicesRepository.deleteById(id);
        }
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        // Get list of services from repository
        // Convert the list of services to a list of serviceDTOs
        // Return the list of serviceDTOs
        List<Services> services = servicesRepository.findAll();
        return services.stream()
                .map(serviceMapper::toDTO)
                .toList();
    }

    private Services getServiceById(String id) {
        return servicesRepository.findById(id).orElse(null);
    }
}
