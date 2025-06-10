package com.inventory.InventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.InventoryManagementSystem.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
