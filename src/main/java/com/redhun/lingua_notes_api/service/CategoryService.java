package com.redhun.lingua_notes_api.service;

import com.redhun.lingua_notes_api.dto.CategoryRequest;
import com.redhun.lingua_notes_api.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse create(CategoryRequest request);

    CategoryResponse update(Long id,
                            CategoryRequest request);

    void delete(Long id);

    List<CategoryResponse> findAll();

    CategoryResponse findById(Long id);

}