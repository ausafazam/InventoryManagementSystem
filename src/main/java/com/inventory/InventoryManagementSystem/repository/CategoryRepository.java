package com.inventory.InventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.InventoryManagementSystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
