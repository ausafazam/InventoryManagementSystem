package com.inventory.InventoryManagementSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.InventoryManagementSystem.dto.LoginRequest;
import com.inventory.InventoryManagementSystem.dto.RegisterRequest;
import com.inventory.InventoryManagementSystem.dto.Response;
import com.inventory.InventoryManagementSystem.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody @Valid RegisterRequest registerRequest){
		return ResponseEntity.ok(userService.registerUser(registerRequest));
	}
	





	 @PostMapping("/login")
	    public ResponseEntity<Response> loginUser(@RequestBody @Valid LoginRequest loginRequest){
	        return ResponseEntity.ok(userService.loginUser(loginRequest));
	    }

}
