package com.minimarvel.model.mapper;

import com.minimarvel.entity.Services;
import com.minimarvel.model.dto.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class ServiceMapper {

    @Autowired
    private PurchaseMapper purchaseMapper;

    public ServiceDTO toDTO(Services services) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(services.getId());
        serviceDTO.setName(services.getName());
        serviceDTO.setPrice(services.getPrice());
        serviceDTO.setDescription(services.getDescription());
        serviceDTO.setStatus(services.getStatus());
        serviceDTO.setImage(services.getImage());
        return serviceDTO;
    }

    public Services toEntity(ServiceDTO serviceDTO) {
        Services services = new Services();
        services.setId(serviceDTO.getId());
        services.setName(serviceDTO.getName());
        services.setPrice(serviceDTO.getPrice());
        services.setDescription(serviceDTO.getDescription());
        services.setStatus(serviceDTO.getStatus());
        services.setImage(serviceDTO.getImage());
        return services;
    }
}
