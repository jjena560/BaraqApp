package com.baraq.store.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.baraq.store.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom query methods here if needed
}
