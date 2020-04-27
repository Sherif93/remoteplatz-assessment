package com.remoteplatz.assessment.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

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
    private float rating;

    @Column(name = "lastUpdate", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.ALL}, orphanRemoval = true)
    Set<MovieCategory> movieCategories;

    public Movie() {
    }

    public Movie(int movieId, String title, @DecimalMin("0.5") @DecimalMax("5") float rating, LocalDateTime lastUpdate, Set<MovieCategory> movieCategories) {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
        this.lastUpdate = lastUpdate;
        this.movieCategories = movieCategories;
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

    public Set<MovieCategory> getMovieCategories() {
        return movieCategories;
    }

    public void setMovieCategories(Set<MovieCategory> movieCategories) {
        this.movieCategories = movieCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", lastUpdate=" + lastUpdate +
                ", movieCategories=" + movieCategories +
                '}';
    }
}
