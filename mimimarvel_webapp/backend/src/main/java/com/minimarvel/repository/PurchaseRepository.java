package com.minimarvel.repository;

import com.minimarvel.entity.Purchase;
import com.minimarvel.model.dto.PurchaseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    @Query("SELECT p FROM Purchase p WHERE p.users.id = :userId")
    List<Purchase> getPurchaseByUserId(Long userId);
}
