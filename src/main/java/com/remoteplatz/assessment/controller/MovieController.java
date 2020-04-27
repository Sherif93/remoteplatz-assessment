package com.remoteplatz.assessment.controller;

import com.remoteplatz.assessment.dto.MovieDto;
import com.remoteplatz.assessment.exception.ResourceNotFoundException;
import com.remoteplatz.assessment.payload.ApiResponse;
import com.remoteplatz.assessment.payload.Movie.AddMovieRequest;
import com.remoteplatz.assessment.payload.Movie.AllMoviesResponse;
import com.remoteplatz.assessment.payload.Movie.MovieResponse;
import com.remoteplatz.assessment.payload.Movie.UpdateMovieRequest;
import com.remoteplatz.assessment.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@Valid @RequestBody AddMovieRequest request) {
        MovieResponse response = new MovieResponse();
        try {
            MovieDto movieDto = new MovieDto();
            movieDto.setCategories(request.getCategories());
            movieDto.setTitle(request.getTitle());
            movieDto.setRating(request.getRating());
            movieService.addMovie(movieDto);

            response.seteCode(0);
            response.seteDesc("Success");
            response.setMovie(movieDto);
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException ex) {
            response.seteCode(-200);
            response.seteDesc(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<AllMoviesResponse> getAllMovies() {
        AllMoviesResponse response = new AllMoviesResponse();
        try {
            List<MovieDto> movieDtoList = movieService.getAllMovies();
            response.seteCode(0);
            response.seteDesc("Success");
            response.setMovies(movieDtoList);
            return new ResponseEntity<AllMoviesResponse>(response, HttpStatus.OK);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovie(@PathVariable @NotBlank(message = "id must not be empty") int id) {
        MovieResponse response = new MovieResponse();
        try {
            MovieDto movieDto = movieService.getMovieById(id);
            response.seteCode(0);
            response.seteDesc("Success");
            response.setMovie(movieDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            response.seteCode(-200);
            response.seteDesc(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<MovieResponse> updateMovie(@Valid @RequestBody UpdateMovieRequest request) {
        MovieResponse response = new MovieResponse();
        try {
            MovieDto movieDto = new MovieDto();
            movieDto.setMovieId(request.getMovieId());
            movieDto.setTitle(request.getTitle());
            movieDto.setRating(request.getRating());
            movieDto.setCategories(request.getCategories());
            movieService.updateMovie(movieDto);

            response.seteCode(0);
            response.seteDesc("Success");
            response.setMovie(movieDto);
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException ex) {
            response.seteCode(-200);
            response.seteDesc(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMovie(@PathVariable @NotBlank(message = "id must not be empty") int id) {
        ApiResponse response = new ApiResponse();
        try {
            movieService.deleteMovie(id);
            response.seteCode(0);
            response.seteDesc("Success");
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException ex) {
            response.seteCode(-200);
            response.seteDesc(ex.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception ex) {
            response.seteCode(-999);
            response.seteDesc("Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
