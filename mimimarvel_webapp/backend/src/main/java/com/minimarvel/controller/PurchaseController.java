package com.minimarvel.controller;

import com.minimarvel.model.dto.PurchaseDTO;
import com.minimarvel.model.dto.PurchaseDetailDTO;
import com.minimarvel.service.impl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseServiceImpl purchaseService;

    @GetMapping("list")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(purchaseService.getAllPurchase());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all purchases failed " + e.getMessage());
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody PurchaseDTO purchaseDTO) {
        try {
            purchaseService.createPurchase(purchaseDTO);
            return ResponseEntity.ok("Create purchase success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create purchase failed " + e.getMessage());
        }
    }

    @PostMapping("createDetail")
    public ResponseEntity<?> createDetail(@RequestBody PurchaseDetailDTO purchaseDetailDTO) {
        try {
            purchaseService.createPurchaseDetail(purchaseDetailDTO);
            return ResponseEntity.ok("Create purchase detail success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create purchase detail failed " + e.getMessage());
        }
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam("orderStatus") String status) {
        try {
            purchaseService.updatePurchase(id, status);
            return ResponseEntity.ok("Update purchase success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update purchase failed " + e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            purchaseService.deletePurchase(id);
            return ResponseEntity.ok("Delete purchase success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete purchase failed " + e.getMessage());
        }
    }

    @GetMapping("getByUser/{userId}")
    public ResponseEntity<?> getByUser(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(purchaseService.getPurchaseByUser(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get purchase by user failed " + e.getMessage());
        }
    }


}
