package com.inventory.InventoryManagementSystem.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.inventory.InventoryManagementSystem.dto.RegisterRequest;
import com.inventory.InventoryManagementSystem.dto.Response;
import com.inventory.InventoryManagementSystem.entity.User;
import com.inventory.InventoryManagementSystem.enums.UserRole;
import com.inventory.InventoryManagementSystem.repository.UserRepository;
import com.inventory.InventoryManagementSystem.security.JwtUtils;
import com.inventory.InventoryManagementSystem.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	//private final PasswordEncoder passwordEncoder;
	private final ModelMapper modelMapper;
	private final JwtUtils jwtUtils;
	
	@Override
    public Response registerUser(RegisterRequest registerRequest) {

        UserRole role = UserRole.MANAGER;

        if (registerRequest.getRole() != null) {
            role=registerRequest.getRole();
        }

        User userToSave = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(role)
                .build();

        userRepository.save(userToSave);

        return Response.builder()
                .status(200)
                .message("user created successfully")
                .build();
    }
	
}
