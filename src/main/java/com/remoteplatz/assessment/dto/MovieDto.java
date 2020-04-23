package com.remoteplatz.assessment.dto;

public class MovieDto {

    private int movieId;
    private int categoryId;
    private String title;
    private float rating;

    public MovieDto() {
    }

    public MovieDto(int movieId, int categoryId, String title, float rating) {
        this.movieId = movieId;
        this.categoryId = categoryId;
        this.title = title;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "MovieDto{" +
                "movieId=" + movieId +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
