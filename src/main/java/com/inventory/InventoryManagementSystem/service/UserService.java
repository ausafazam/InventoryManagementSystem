package com.inventory.InventoryManagementSystem.service;

import com.inventory.InventoryManagementSystem.dto.LoginRequest;
import com.inventory.InventoryManagementSystem.dto.RegisterRequest;
import com.inventory.InventoryManagementSystem.dto.Response;
import com.inventory.InventoryManagementSystem.dto.UserDTO;
import com.inventory.InventoryManagementSystem.entity.User;

public interface UserService {

	Response registerUser(RegisterRequest registerRequest);

	Response getAllUsers();

	User getCurrentLoggedInUser();

	Response updateUser(Long id, UserDTO userDTO);

	Response deleteUser(Long id);

	Response getUserTransactions(Long id);

	Response loginUser(LoginRequest loginRequest);

}
