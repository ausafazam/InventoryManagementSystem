package com.inventory.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.dto.ProductDTO;
import com.inventory.dto.Response;
import com.inventory.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> saveProduct(
       
    		@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            @RequestParam("name") String  name,
            @RequestParam("sku") String  sku,
            @RequestParam("price") BigDecimal price,
            @RequestParam("stockQuantity") Integer  stockQuantity,
            @RequestParam("categoryId") Long  categoryId,
            @RequestParam(value = "description", required = false) String  description
            ) {




        ProductDTO productDTO = new ProductDTO();

        productDTO.setName(name);
        productDTO.setSku(sku);
        productDTO.setPrice(price);
        productDTO.setStockQuantity(stockQuantity);
        productDTO.setCategoryId(categoryId);
        productDTO.setDescription(description);

        System.out.println(productDTO);


        return ResponseEntity.ok(productService.saveProduct(productDTO, imageFile));
    }
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> updateProduct(
            @RequestParam(value = "imageFile", required=false) MultipartFile imageFile,
            @RequestParam(value = "name",required = false) String  name,
            @RequestParam(value = "sku",required = false) String  sku,
            @RequestParam(value = "price",required = false) BigDecimal price,
            @RequestParam(value = "stockQuantity",required = false) Integer  stockQuantity,
            @RequestParam(value = "productId",required = true) Long  productId,
            @RequestParam(value = "categoryId",required = false) Long  categoryId,
            @RequestParam(value = "description", required = false) String  description
    ) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setName(name);
        productDTO.setSku(sku);
        productDTO.setPrice(price);
        productDTO.setStockQuantity(stockQuantity);
        productDTO.setCategoryId(categoryId);
        productDTO.setProductId(productId);
        productDTO.setDescription(description);

        return ResponseEntity.ok(productService.updateProduct(productDTO, imageFile));
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }


}