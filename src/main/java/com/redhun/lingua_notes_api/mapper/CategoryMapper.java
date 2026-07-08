package com.redhun.lingua_notes_api.mapper;

import com.redhun.lingua_notes_api.dto.CategoryRequest;
import com.redhun.lingua_notes_api.dto.CategoryResponse;
import com.redhun.lingua_notes_api.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setIcon(request.getIcon());
        return category;
    }

    public static CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        response.setIcon(category.getIcon());
        return response;
    }

    public static void updateEntity(Category category, CategoryRequest request) {
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setIcon(request.getIcon());
    }
}