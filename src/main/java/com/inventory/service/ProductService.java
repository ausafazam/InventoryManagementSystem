package com.inventory.service;

import org.springframework.web.multipart.MultipartFile;

import com.inventory.dto.ProductDTO;
import com.inventory.dto.Response;

public interface ProductService {
    Response saveProduct(ProductDTO productDTO, MultipartFile imageFile);
    Response updateProduct(ProductDTO productDTO, MultipartFile imageFile);
    Response getAllProducts();
    Response getProductById(Long id);
    Response deleteProduct(Long id);
}
