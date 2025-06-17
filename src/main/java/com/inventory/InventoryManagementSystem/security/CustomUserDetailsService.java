package com.inventory.InventoryManagementSystem.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inventory.InventoryManagementSystem.entity.User;
import com.inventory.InventoryManagementSystem.exceptions.NotFoundException;
import com.inventory.InventoryManagementSystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(()-> new NotFoundException("User Email Not Found"));

        return AuthUser.builder()
                .user(user)
                .build();
    }
}
