package com.minimarvel.service;

import com.minimarvel.model.dto.VoucherDTO;

import java.util.List;

public interface VoucherService {
    void createVoucher(VoucherDTO voucherDTO);
    void updateVoucher(String id, VoucherDTO voucherDTO);
    void deleteVoucher(String id);
    List<VoucherDTO> getAllVouchers();
    VoucherDTO getVoucherByIdDTO(String id);
}
