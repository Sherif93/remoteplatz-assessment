package com.remoteplatz.assessment.model;

import java.io.Serializable;
import java.util.Objects;

public class MovieCategoryId implements Serializable {

    private int movieId;

    private int categoryId;

    public MovieCategoryId() {
    }

    public MovieCategoryId(int movieId, int categoryId) {
        this.movieId = movieId;
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCategoryId that = (MovieCategoryId) o;
        return movieId == that.movieId &&
                categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, categoryId);
    }

    @Override
    public String toString() {
        return "MovieCategoryId{" +
                "movieId=" + movieId +
                ", categoryId=" + categoryId +
                '}';
    }
}
