package com.inventory.InventoryManagementSystem.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Sku is required")
	@Column(unique = true)
	private String sku;
	
	@Positive(message = "Product price must be a positive value")
	private BigDecimal price;
	
	@Min(value = 0, message = "Stock quantity cannot be lesser than zero")
	private BigInteger stockQuantity;
	
	private String description;
	
	private String imageUrl;
	
	private LocalDateTime expiryDate;
	
	private LocalDateTime updatedAt;
	
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", sku=" + sku + ", price=" + price + ", stockQuantity="
				+ stockQuantity + ", description=" + description + ", imageUrl=" + imageUrl + ", expiryDate="
				+ expiryDate + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
}
