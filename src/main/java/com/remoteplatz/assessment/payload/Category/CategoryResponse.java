package com.remoteplatz.assessment.payload.Category;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.remoteplatz.assessment.dto.CategoryDto;
import com.remoteplatz.assessment.payload.ApiResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponse extends ApiResponse {

    private CategoryDto category;

    public CategoryResponse() {
    }

    public CategoryResponse(int eCode, String eDesc, CategoryDto category) {
        super(eCode, eDesc);
        this.category = category;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "AddUpdateCategoryResponse{" +
                "category=" + category +
                '}';
    }
}
