package com.baraq.store.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baraq.store.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // You can add custom methods if needed
}
