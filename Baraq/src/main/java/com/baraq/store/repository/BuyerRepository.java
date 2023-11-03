package com.baraq.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baraq.store.model.Buyer;


public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}
