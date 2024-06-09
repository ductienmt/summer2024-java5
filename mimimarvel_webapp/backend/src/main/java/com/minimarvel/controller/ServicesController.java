package com.minimarvel.controller;


import com.minimarvel.model.dto.ServiceDTO;
import com.minimarvel.service.impl.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesServiceImpl servicesService;

    @GetMapping("list")
    public ResponseEntity<?> getAll() {
        try {

            return ResponseEntity.ok(servicesService.getAllServices());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all services failed " + e.getMessage());
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ServiceDTO servicesDTO) {
        try {
            servicesService.createService(servicesDTO);
            return ResponseEntity.ok("Create service success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create service failed "+ e.getMessage());
        }
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ServiceDTO servicesDTO) {
        try {
            servicesService.updateService(id, servicesDTO);
            return ResponseEntity.ok("Update service success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update service failed "+ e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            servicesService.deleteService(id);
            return ResponseEntity.ok("Delete service success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete service failed "+ e.getMessage());
        }
    }
}
