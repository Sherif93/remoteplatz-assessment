package com.remoteplatz.assessment.payload.Category;

import javax.validation.constraints.NotBlank;

public class UpdateCategoryRequest {

    @NotBlank(message = "id must not be null or empty")
    private int id;
    @NotBlank(message = "title must not be null or empty")
    private String title;
    private String desc;

    public UpdateCategoryRequest() {
    }

    public UpdateCategoryRequest(int id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "CategoryRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
