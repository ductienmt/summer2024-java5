package com.minimarvel.repository;

import com.minimarvel.entity.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Long>{
    @Query("SELECT pd FROM PurchaseDetail pd WHERE pd.purchase.id = :purchaseId")
    List<PurchaseDetail> findByPurchaseId(@Param("purchaseId") Long purchaseId);
}
