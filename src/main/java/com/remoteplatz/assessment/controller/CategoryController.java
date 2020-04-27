package com.remoteplatz.assessment.controller;

import com.remoteplatz.assessment.dto.CategoryDto;
import com.remoteplatz.assessment.exception.DuplicateCategoryException;
import com.remoteplatz.assessment.exception.ResourceNotFoundException;
import com.remoteplatz.assessment.payload.Category.AddCategoryRequest;
import com.remoteplatz.assessment.payload.Category.CategoryResponse;
import com.remoteplatz.assessment.payload.Category.GetAllCategoriesResponse;
import com.remoteplatz.assessment.payload.Category.UpdateCategoryRequest;
import com.remoteplatz.assessment.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody AddCategoryRequest request) {
        CategoryResponse response = new CategoryResponse();
        try {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setTitle(request.getTitle());
            categoryDto.setDesc(request.getDesc());
            categoryService.addCategory(categoryDto);

            response.seteCode(0);
            response.seteDesc("Success");
            response.setCategory(categoryDto);

            return ResponseEntity.ok(response);
        } catch (DuplicateCategoryException ex) {
            response.seteCode(-100);
            response.seteDesc("Category is already inserted");
            return ResponseEntity.badRequest().body(response);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<GetAllCategoriesResponse> getAllCategories() {
        GetAllCategoriesResponse response = new GetAllCategoriesResponse();
        try {
            response.setCategories(categoryService.getAllCategories());
            response.seteCode(0);
            response.seteDesc("Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<CategoryResponse> updateCategories(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        CategoryResponse response = new CategoryResponse();

        try {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(updateCategoryRequest.getId());
            categoryDto.setTitle(updateCategoryRequest.getTitle());
            categoryDto.setDesc(updateCategoryRequest.getDesc());
            categoryService.updateCategory(categoryDto);

            response.seteCode(0);
            response.seteDesc("Success");
            response.setCategory(categoryDto);

            return ResponseEntity.ok(response);
        } catch (DuplicateCategoryException ex) {
            response.seteCode(-100);
            response.seteDesc("Category is already inserted");
            return ResponseEntity.badRequest().body(response);
        } catch (ResourceNotFoundException ex) {
            response.seteCode(-200);
            response.seteDesc(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
