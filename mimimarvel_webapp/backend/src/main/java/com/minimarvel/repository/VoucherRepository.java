package com.minimarvel.repository;

import com.minimarvel.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, String> {
}
