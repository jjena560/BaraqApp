package com.baraq.store.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.baraq.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
