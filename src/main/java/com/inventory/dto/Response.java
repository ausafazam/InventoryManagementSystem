package com.inventory.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inventory.enums.UserRole;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
	//generic 
	private int status;
	private String message;
	//for login
	private String token;
	private UserRole role;
	private String expirationTime;
	
	//for pagination
	private Integer totalPages;
	private Long totalElement;
	
	
	//data output optional
	private UserDTO user;
	private List<UserDTO> users;
	
	private SupplierDTO supplier;
	private List<SupplierDTO> suppliers;
	
	private CategoryDTO category;
	private List<CategoryDTO> categories;
	
	private ProductDTO product;
	private List<ProductDTO> products;
	
	
	private TransactionDTO transaction;
	private List<TransactionDTO> transactions;
	
	private final LocalDateTime timestamp = LocalDateTime.now();
	

}
