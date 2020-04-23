package com.remoteplatz.assessment.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie_category")
@IdClass(MovieCategoryId.class)
public class MovieCategory {

    @Id
    private int movieId;

    @Id
    private int categoryId;

    @Column(name = "lastUpdate", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public MovieCategory() {
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "MovieCategory{" +
                "movieId=" + movieId +
                ", categoryId=" + categoryId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
