package com.minimarvel.controller;


import com.minimarvel.model.dto.BrandDTO;
import com.minimarvel.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandServiceImpl brandService;

    @GetMapping("list")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(brandService.getAllBrands());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all brands failed");
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(brandService.getBrandById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get brand failed");
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
        try {
            brandService.createBrand(brandDTO);
            return ResponseEntity.ok("Create brand success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create brand failed");
        }
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody BrandDTO brandDTO) {
        try {
            brandService.updateBrand(brandDTO);
            return ResponseEntity.ok("Update brand success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update brand failed");
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            brandService.deleteBrand(id);
            return ResponseEntity.ok("Delete brand success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete brand failed");
        }
    }
}
