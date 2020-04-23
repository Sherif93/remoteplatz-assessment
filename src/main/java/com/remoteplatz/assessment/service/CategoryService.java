package com.remoteplatz.assessment.service;

import com.remoteplatz.assessment.dto.CategoryDto;
import com.remoteplatz.assessment.model.Category;
import com.remoteplatz.assessment.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setTitle(categoryDto.getTitle());
        category.setDesc(categoryDto.getDesc());
        category = categoryRepository.save(category);
        categoryDto.setId(category.getCategoryId());
        return categoryDto;
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

        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setTitle(categoryDto.getTitle());
            category.setDesc(categoryDto.getDesc());
            categoryRepository.save(category);
        }
    }
}
