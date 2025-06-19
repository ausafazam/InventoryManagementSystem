package com.inventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.Response;
import com.inventory.dto.UserDTO;
import com.inventory.entity.User;
import com.inventory.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	private UserService userService;

	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Response> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Response> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.updateUser(id, userDTO));
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Response> deleteUser(@PathVariable Long id) {
		return ResponseEntity.ok(userService.deleteUser(id));
	}

	@GetMapping("/transactions/{userId}")
	public ResponseEntity<Response> getUserAndTransactions(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUserTransactions(userId));
	}

	@GetMapping("/current")
	public ResponseEntity<User> getCurrentUser() {
		return ResponseEntity.ok(userService.getCurrentLoggedInUser());
	}
}