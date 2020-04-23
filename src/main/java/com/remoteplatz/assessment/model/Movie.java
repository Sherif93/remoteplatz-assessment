package com.remoteplatz.assessment.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rating")
    @DecimalMin("0.5")
    @DecimalMax("5")
    private float rating;

    @Column(name = "lastUpdate", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Movie() {
    }

    public Movie(String title, @DecimalMin("0.5") @DecimalMax("5") float rating, LocalDateTime lastUpdate) {
        this.title = title;
        this.rating = rating;
        this.lastUpdate = lastUpdate;
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
