package com.inventory.service;

import com.inventory.dto.LoginRequest;
import com.inventory.dto.RegisterRequest;
import com.inventory.dto.Response;
import com.inventory.dto.UserDTO;
import com.inventory.entity.User;

public interface UserService {

	Response registerUser(RegisterRequest registerRequest);

	Response getAllUsers();

	User getCurrentLoggedInUser();

	Response updateUser(Long id, UserDTO userDTO);

	Response deleteUser(Long id);

	Response getUserTransactions(Long id);

	Response loginUser(LoginRequest loginRequest);

}
