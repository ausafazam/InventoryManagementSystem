package com.inventory.InventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.InventoryManagementSystem.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
