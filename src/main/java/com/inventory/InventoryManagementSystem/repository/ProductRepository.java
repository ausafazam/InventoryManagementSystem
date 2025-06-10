package com.inventory.InventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.InventoryManagementSystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
