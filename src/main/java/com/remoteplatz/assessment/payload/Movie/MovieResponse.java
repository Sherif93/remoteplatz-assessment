package com.remoteplatz.assessment.payload.Movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.remoteplatz.assessment.dto.MovieDto;
import com.remoteplatz.assessment.payload.ApiResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponse extends ApiResponse {

    private MovieDto movie;

    public MovieResponse() {
    }

    public MovieResponse(int eCode, String eDesc, MovieDto movie) {
        super(eCode, eDesc);
        this.movie = movie;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "AddMovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
