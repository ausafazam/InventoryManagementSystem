package com.inventory.InventoryManagementSystem.service;

import com.inventory.InventoryManagementSystem.dto.LoginRequest;
import com.inventory.InventoryManagementSystem.dto.RegisterRequest;
import com.inventory.InventoryManagementSystem.dto.Response;
import com.inventory.InventoryManagementSystem.dto.UserDTO;
import com.inventory.InventoryManagementSystem.entity.User;

public interface UserService {
<<<<<<< HEAD
    Response registerUser(RegisterRequest registerRequest);
=======
	
	Response registerUser(RegisterRequest registerRequest);

	
	Response getAllUsers();
	
	User getCurrentLoggedInUser();
	
	Response updateUser(Long id, UserDTO userDTO);
	
	Response deleteUser(Long id);
	
	Response getUserTransactions(Long id);
	

>>>>>>> e1db0747b8a5629905915e1ad493454439444edc
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getCurrentLoggedInUser();
    Response updateUser(Long id, UserDTO userDTO);
    Response deleteUser(Long id);
    Response getUserTransactions(Long id);
}