package com.remoteplatz.assessment.payload.Movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.remoteplatz.assessment.dto.MovieDto;
import com.remoteplatz.assessment.payload.ApiResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllMoviesResponse extends ApiResponse {
    List<MovieDto> movies;

    public AllMoviesResponse() {
    }

    public AllMoviesResponse(int eCode, String eDesc, List<MovieDto> movies) {
        super(eCode, eDesc);
        this.movies = movies;
    }

    public List<MovieDto> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDto> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "GetAllMoviesResponse{" +
                "movies=" + movies +
                '}';
    }
}
