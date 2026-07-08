package com.redhun.lingua_notes_api.service.impl;

import com.redhun.lingua_notes_api.dto.CategoryRequest;
import com.redhun.lingua_notes_api.dto.CategoryResponse;
import com.redhun.lingua_notes_api.entity.Category;
import com.redhun.lingua_notes_api.mapper.CategoryMapper;
import com.redhun.lingua_notes_api.repository.CategoryRepository;
import com.redhun.lingua_notes_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service


public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category = CategoryMapper.toEntity(request);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toResponse(saved);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        CategoryMapper.updateEntity(category, request);

        Category updated = categoryRepository.save(category);
        return CategoryMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }

        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return CategoryMapper.toResponse(category);
    }
}
