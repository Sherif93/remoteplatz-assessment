package com.remoteplatz.assessment.service;

import com.remoteplatz.assessment.dto.CategoryDto;
import com.remoteplatz.assessment.exception.DuplicateCategoryException;
import com.remoteplatz.assessment.exception.ResourceNotFoundException;
import com.remoteplatz.assessment.model.Category;
import com.remoteplatz.assessment.repository.CategoryRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(CategoryDto categoryDto) {
        try {
            Category category = new Category();
            category.setTitle(categoryDto.getTitle());
            category.setDesc(categoryDto.getDesc());
            category = categoryRepository.save(category);
            categoryDto.setId(category.getCategoryId());
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateCategoryException();
        }
    }

    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        categories.forEach(item -> {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(item.getCategoryId());
            categoryDto.setTitle(item.getTitle());
            categoryDto.setDesc(item.getDesc());
            categoryDtos.add(categoryDto);
        });

        return categoryDtos;
    }

    public void updateCategory(CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getId());
        Category category = optionalCategory.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryDto.getId()));
        try {
            category.setTitle(categoryDto.getTitle());
            category.setDesc(categoryDto.getDesc());
            categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateCategoryException();
        }
    }
}
