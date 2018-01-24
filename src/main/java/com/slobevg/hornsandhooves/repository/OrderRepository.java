package com.slobevg.hornsandhooves.repository;

import com.slobevg.hornsandhooves.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
