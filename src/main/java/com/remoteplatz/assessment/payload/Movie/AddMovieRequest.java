package com.remoteplatz.assessment.payload.Movie;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.util.Set;

public class AddMovieRequest {

    private String title;
    @DecimalMin(value = "0.5", message = "rating must be between 0.5 and 5 inclusive")
    @DecimalMax(value = "5.0", message = "rating must be between 0.5 and 5 inclusive")
    private float rating;
    private Set<Integer> categories;

    public AddMovieRequest() {
    }

    public AddMovieRequest(String title, float rating, Set<Integer> categories) {
        this.title = title;
        this.rating = rating;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Set<Integer> getCategories() {
        return categories;
    }

    public void setCategories(Set<Integer> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "AddMovieRequest{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", categories=" + categories +
                '}';
    }
}
