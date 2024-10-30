package com.product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product_management.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
