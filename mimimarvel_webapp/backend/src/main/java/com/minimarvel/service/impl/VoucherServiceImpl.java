package com.minimarvel.service.impl;

import com.minimarvel.entity.Voucher;
import com.minimarvel.model.dto.VoucherDTO;
import com.minimarvel.model.mapper.VoucherMapper;
import com.minimarvel.repository.VoucherRepository;
import com.minimarvel.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService{
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private VoucherMapper voucherMapper;


    @Override
    public void createVoucher(VoucherDTO voucherDTO) {
        // Create a voucher from the voucherDTO
        // Save the voucher to the repository
        Voucher voucher = voucherMapper.toEntity(voucherDTO);
        voucherRepository.save(voucher);
    }

    @Override
    public void updateVoucher(String id, VoucherDTO voucherDTO) {
        // Find the voucher by id
        // Update the voucher with the new voucherDTO
        // Save the voucher to the repository
        Voucher voucher = getVoucherById(id);
        if(voucher != null) {
            voucher.setName(voucherDTO.getName());
            voucher.setDiscount(voucherDTO.getDiscount());
            voucher.setDateStart(voucherDTO.getDateStart());
            voucher.setDateEnd(voucherDTO.getDateEnd());
            voucher.setUsage(voucherDTO.getUsage());
            voucherRepository.save(voucher);
        }
    }

    @Override
    public void deleteVoucher(String id) {
        // Find the voucher by id
        // Delete the voucher from the repository
        if (this.getVoucherById(id) != null) {
            voucherRepository.deleteById(id);
        }
    }

    @Override
    public List<VoucherDTO> getAllVouchers() {
        // Get list of vouchers from repository
        // Convert the list of vouchers to a list of voucherDTOs
        // Return the list of voucherDTOs
        List<Voucher> vouchers = voucherRepository.findAll();
        return vouchers.stream()
                .map(voucherMapper::toDTO)
                .toList();
    }

    @Override
    public VoucherDTO getVoucherByIdDTO(String id) {
        return voucherMapper.toDTO(getVoucherById(id));
    }

    private Voucher getVoucherById(String id) {
        return voucherRepository.findById(id).orElse(null);
    }
}
