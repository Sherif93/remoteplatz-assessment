package com.remoteplatz.assessment.controller;

//import com.remoteplatz.assessment.controller.request.CategoryRequest;
import com.remoteplatz.assessment.dto.CategoryDto;
import com.remoteplatz.assessment.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @PostMapping
//    public CategoryDto addCategory(@RequestBody CategoryRequest categoryRequest) {
//        CategoryDto requestDto = new CategoryDto();
//        requestDto.setTitle(categoryRequest.getTitle());
//        requestDto.setDesc(categoryRequest.getDesc());
//
//        CategoryDto responseDto = categoryService.addCategory(requestDto);
//        return requestDto;
//    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> response = categoryService.getAllCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity<CategoryDto> updateCategories(@RequestBody CategoryRequest categoryRequest){
//        CategoryDto requestDto = new CategoryDto();
//        requestDto.setId(categoryRequest.getId());
//        requestDto.setTitle(categoryRequest.getTitle());
//        requestDto.setDesc(categoryRequest.getDesc());
//
//        categoryService.updateCategory(requestDto);
//        return new ResponseEntity<CategoryDto>(requestDto, HttpStatus.OK);
//    }

}
