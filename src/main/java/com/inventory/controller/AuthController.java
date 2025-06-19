package com.inventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.LoginRequest;
import com.inventory.dto.RegisterRequest;
import com.inventory.dto.Response;
import com.inventory.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
	
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody @Valid RegisterRequest registerRequest){
		return ResponseEntity.ok(userService.registerUser(registerRequest));
	}
	

	 @PostMapping("/login")
	    public ResponseEntity<Response> loginUser(@RequestBody @Valid LoginRequest loginRequest){
	        return ResponseEntity.ok(userService.loginUser(loginRequest));
	    }

}
