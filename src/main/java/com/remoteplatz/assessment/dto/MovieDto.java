package com.remoteplatz.assessment.dto;

import java.util.HashSet;
import java.util.Set;

public class MovieDto {

    private int movieId;
    private String title;
    private float rating;
    private Set<Integer> categories = new HashSet<>();

    public MovieDto() {
    }

    public MovieDto(int movieId, String title, float rating, Set<Integer> categories) {
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
        return "MovieDto{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", categories=" + categories +
                '}';
    }
}
