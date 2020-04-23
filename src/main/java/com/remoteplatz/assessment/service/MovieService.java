package com.remoteplatz.assessment.service;

import com.remoteplatz.assessment.dto.MovieDto;
import com.remoteplatz.assessment.model.Movie;
import com.remoteplatz.assessment.repository.CategoryRepository;
import com.remoteplatz.assessment.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private CategoryRepository categoryRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieDto addMovie(MovieDto movieDto) {
//        categoryRepository.findById()
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setRating(movieDto.getRating());
        movie = movieRepository.save(movie);

        movieDto.setMovieId(movie.getMovieId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setRating(movie.getRating());
        return movieDto;
    }

    public List<MovieDto> getAllMovies() {
        List<MovieDto> movieDtoList = new ArrayList<>();
        List<Movie> movies = movieRepository.findAll();
        movies.forEach((item) -> {
            MovieDto dto = new MovieDto();
            dto.setMovieId(item.getMovieId());
            dto.setTitle(item.getTitle());
            dto.setRating(item.getRating());
            movieDtoList.add(dto);
        });
        return movieDtoList;
    }

    public MovieDto getMovieById(Integer id) {
        MovieDto movieDto = new MovieDto();
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movieDto.setMovieId(movie.getMovieId());
            movieDto.setTitle(movie.getTitle());
            movieDto.setRating(movie.getRating());
        }
        return movieDto;
    }

    public void deleteMovie(int id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movieRepository.delete(movie);
        }
    }

    public MovieDto updateMovie(MovieDto movieDto) {
        MovieDto responseDto = null;
        Optional<Movie> optionalMovie = movieRepository.findById(movieDto.getMovieId());
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(movieDto.getTitle());
            movie.setRating(movieDto.getRating());
            movie = movieRepository.save(movie);

            responseDto = new MovieDto();
            responseDto.setMovieId(movie.getMovieId());
            responseDto.setTitle(movie.getTitle());
            responseDto.setRating(movie.getRating());
        }
        return responseDto;
    }
}
