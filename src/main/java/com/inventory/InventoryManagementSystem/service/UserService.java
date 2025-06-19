package com.inventory.InventoryManagementSystem.service;

import com.inventory.dto.LoginRequest;
import com.inventory.dto.RegisterRequest;
import com.inventory.dto.Response;
import com.inventory.dto.UserDTO;
import com.inventory.entity.User;

public interface UserService {

    Response registerUser(RegisterRequest registerRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getCurrentLoggedInUser();
    Response updateUser(Long id, UserDTO userDTO);
    Response deleteUser(Long id);
    Response getUserTransactions(Long id);
}




