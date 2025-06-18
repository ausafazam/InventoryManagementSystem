package com.inventory.InventoryManagementSystem.service.impl;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.inventory.InventoryManagementSystem.dto.CategoryDTO;
import com.inventory.InventoryManagementSystem.dto.Response;
import com.inventory.InventoryManagementSystem.entity.Category;
import com.inventory.InventoryManagementSystem.exceptions.NotFoundException;
import com.inventory.InventoryManagementSystem.repository.CategoryRepository;
import com.inventory.InventoryManagementSystem.service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response createCategory(CategoryDTO categoryDTO) {
        Category categoryToSave = modelMapper.map(categoryDTO, Category.class);
        categoryRepository.save(categoryToSave);

        return Response.builder()
                .status(200)
                .message("Category created successfully")
                .build();
    }

    @Override
    public Response getAllCategories() {

        List<Category> categories = categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        List<CategoryDTO> categoryDTOS = modelMapper.map(categories, new TypeToken<List<CategoryDTO>>() {}.getType());

        return Response.builder()
                .status(200)
                .message("success")
                .categories(categoryDTOS)
                .build();
    }

    @Override
    public Response getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category Not Found"));
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);

        return Response.builder()
                .status(200)
                .message("success")
                .category(categoryDTO)
                .build();
    }

    @Override
    public Response updateCategory(Long id, CategoryDTO categoryDTO) {

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category Not Found"));

        existingCategory.setName(categoryDTO.getName());
        categoryRepository.save(existingCategory);

        return Response.builder()
                .status(200)
                .message("Category Successfully Updated")
                .build();

    }

    @Override
    public Response deleteCategory(Long id) {

         categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category Not Found"));

        categoryRepository.deleteById(id);

        return Response.builder()
                .status(200)
                .message("Category Successfully Deleted")
                .build();
    }
}
