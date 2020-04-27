package com.remoteplatz.assessment.payload.Movie;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class UpdateMovieRequest {

    @NotNull
    private int movieId;
    private String title;
    @DecimalMin(value = "0.5", message = "rating must be between 0.5 and 5 inclusive")
    @DecimalMax(value = "5.0", message = "rating must be between 0.5 and 5 inclusive")
    private float rating;
    private Set<Integer> categories = new HashSet<>();

    public UpdateMovieRequest() {
    }

    public UpdateMovieRequest(int movieId, String title, float rating, Set<Integer> categories) {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
        this.categories = categories;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
        return "UpdateMovieRequest{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", categories=" + categories +
                '}';
    }
}
