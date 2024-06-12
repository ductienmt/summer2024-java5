package com.minimarvel.repository;

import com.minimarvel.entity.PurchaseDetail;
import com.minimarvel.model.dto.ProductDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Long>{
    @Query("SELECT pd FROM PurchaseDetail pd WHERE pd.purchase.id = :purchaseId")
    List<PurchaseDetail> findByPurchaseId(@Param("purchaseId") Long purchaseId);

    @Query("SELECT pd.product.id FROM PurchaseDetail pd GROUP BY pd.product.id ORDER BY SUM(pd.quantity) DESC")
    List<Integer> findTop5MostPurchasedProductIds(Pageable pageable);
}
