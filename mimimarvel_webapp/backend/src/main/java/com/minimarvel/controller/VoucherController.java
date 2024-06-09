package com.minimarvel.controller;

import com.minimarvel.model.dto.VoucherDTO;
import com.minimarvel.service.impl.VoucherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5050/")
@RequestMapping("/vouchers")
public class VoucherController {
    @Autowired
    private VoucherServiceImpl voucherService;

    @GetMapping("list")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(voucherService.getAllVouchers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all vouchers failed " + e.getMessage());
        }
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@RequestParam String id) {
        try {
            return ResponseEntity.ok(voucherService.getVoucherByIdDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get voucher by id failed "+ e.getMessage());
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody VoucherDTO voucherDTO) {
        try {
            voucherService.createVoucher(voucherDTO);
            return ResponseEntity.ok("Create voucher success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Create voucher failed "+ e.getMessage());
        }
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody VoucherDTO voucherDTO) {
        try {
            voucherService.updateVoucher(id, voucherDTO);
            return ResponseEntity.ok("Update voucher success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update voucher failed "+ e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            voucherService.deleteVoucher(id);
            return ResponseEntity.ok("Delete voucher success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Delete voucher failed "+ e.getMessage());
        }
    }
}
