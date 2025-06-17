package com.inventory.InventoryManagementSystem.service;

import com.inventory.InventoryManagementSystem.dto.RegisterRequest;
import com.inventory.InventoryManagementSystem.dto.Response;

public interface UserService {
	
	Response registerUser(RegisterRequest registerRequest);

}
