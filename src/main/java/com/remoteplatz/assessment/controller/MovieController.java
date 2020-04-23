package com.remoteplatz.assessment.controller;

import com.remoteplatz.assessment.dto.MovieDto;
import com.remoteplatz.assessment.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieDto addMovie(@RequestBody MovieDto request) {
        MovieDto movieDto = movieService.addMovie(request);
        return movieDto;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movieDtoList = movieService.getAllMovies();
        return new ResponseEntity<List<MovieDto>>(movieDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable int id) {
        MovieDto movieDto = movieService.getMovieById(id);
        return new ResponseEntity<MovieDto>(movieDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto request) {
        MovieDto requestDto = new MovieDto();
        requestDto.setMovieId(request.getMovieId());
        requestDto.setTitle(request.getTitle());
        requestDto.setRating(request.getRating());
        MovieDto responseDto = movieService.updateMovie(requestDto);
        return new ResponseEntity<MovieDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
