package com.remoteplatz.assessment.payload.Category;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.remoteplatz.assessment.dto.CategoryDto;
import com.remoteplatz.assessment.payload.ApiResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllCategoriesResponse extends ApiResponse {

    List<CategoryDto> categories;

    public GetAllCategoriesResponse() {
    }

    public GetAllCategoriesResponse(int eCode, String eDesc, List<CategoryDto> categories) {
        super(eCode, eDesc);
        this.categories = categories;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "GetAllCategoriesResponse{" +
                "categoryDtos=" + categories +
                '}';
    }
}
