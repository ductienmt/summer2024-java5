package com.lab5.model.DAO;

import com.lab5.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
}
