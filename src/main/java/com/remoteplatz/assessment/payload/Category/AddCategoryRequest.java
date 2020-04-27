package com.remoteplatz.assessment.payload.Category;

import javax.validation.constraints.NotBlank;

public class AddCategoryRequest {

    @NotBlank(message = "title must not be null or empty")
    private String title;
    private String desc;

    public AddCategoryRequest() {
    }

    public AddCategoryRequest(@NotBlank String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "AddCategoryRequest{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
