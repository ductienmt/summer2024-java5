package com.minimarvel.model.mapper;

import com.minimarvel.entity.Voucher;
import com.minimarvel.model.dto.VoucherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VoucherMapper {
    @Autowired
    private PurchaseMapper purchaseMapper;

    public VoucherDTO toDTO(Voucher voucher) {
        VoucherDTO voucherDTO = new VoucherDTO();
        voucherDTO.setId(voucher.getId());
        voucherDTO.setName(voucher.getName());
        voucherDTO.setDiscount(voucher.getDiscount());
        voucherDTO.setDateStart(voucher.getDateStart());
        voucherDTO.setDateEnd(voucher.getDateEnd());
        voucherDTO.setUsage(voucher.getUsage());
        return voucherDTO;
    }

    public Voucher toEntity(VoucherDTO voucherDTO) {
        Voucher voucher = new Voucher();
        voucher.setId(voucherDTO.getId());
        voucher.setName(voucherDTO.getName());
        voucher.setDiscount(voucherDTO.getDiscount());
        voucher.setDateStart(voucherDTO.getDateStart());
        voucher.setDateEnd(voucherDTO.getDateEnd());
        voucher.setUsage(voucherDTO.getUsage());
        return voucher;
    }
}
