package com.inventory.InventoryManagementSystem.service;

import com.inventory.InventoryManagementSystem.dto.CategoryDTO;
import com.inventory.InventoryManagementSystem.dto.Response;

public interface CategoryService {
    Response createCategory(CategoryDTO categoryDTO);
    Response getAllCategories();
    Response getCategoryById(Long id);
    Response updateCategory(Long id, CategoryDTO categoryDTO);
    Response deleteCategory(Long id);
}
