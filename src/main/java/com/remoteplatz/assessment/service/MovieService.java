package com.remoteplatz.assessment.service;

import com.remoteplatz.assessment.dto.MovieDto;
import com.remoteplatz.assessment.exception.ResourceNotFoundException;
import com.remoteplatz.assessment.model.Category;
import com.remoteplatz.assessment.model.Movie;
import com.remoteplatz.assessment.model.MovieCategory;
import com.remoteplatz.assessment.repository.CategoryRepository;
import com.remoteplatz.assessment.repository.MovieCategoryRepository;
import com.remoteplatz.assessment.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;
    private final MovieCategoryRepository movieCategoryRepository;

    public MovieService(MovieRepository movieRepository, CategoryRepository categoryRepository, MovieCategoryRepository movieCategoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
        this.movieCategoryRepository = movieCategoryRepository;
    }

    public void addMovie(MovieDto movieDto) {

        List<Category> categories = categoryRepository.findAllById(movieDto.getCategories());

        if (categories.size() > 0 && movieDto.getCategories().size() == categories.size()) {
            Movie movie = new Movie();
            movie.setTitle(movieDto.getTitle());
            movie.setRating(movieDto.getRating());
            movie = movieRepository.save(movie);
            movieDto.setMovieId(movie.getMovieId());

            List<MovieCategory> movieCategories = new ArrayList<>();
            for (Category category : categories) {
                MovieCategory movieCategory = new MovieCategory();
                movieCategory.setCategoryId(category.getCategoryId());
                movieCategory.setMovieId(movie.getMovieId());
                movieCategories.add(movieCategory);
            }

            movieCategories = movieCategoryRepository.saveAll(movieCategories);
            Set<Integer> categoriesId = new HashSet<>();
            for (MovieCategory movieCategory : movieCategories) {
                categoriesId.add(movieCategory.getCategoryId());
            }
            movieDto.setCategories(categoriesId);
        } else {
            throw new ResourceNotFoundException("One or more of the categories", "categoriesId", movieDto.getCategories());
        }

    }

    public List<MovieDto> getAllMovies() {
        List<MovieDto> movieDtoList = new ArrayList<>();
        List<Movie> movies = movieRepository.findAll();
        movies.forEach((movie) -> {
            MovieDto movieDto = new MovieDto();
            movieDto.setMovieId(movie.getMovieId());
            movieDto.setTitle(movie.getTitle());
            movieDto.setRating(movie.getRating());
            Set<Integer> categoriesIds = new HashSet<>();
            movie.getMovieCategories().forEach((item) -> {
                categoriesIds.add(item.getCategoryId());
            });
            movieDto.setCategories(categoriesIds);
            movieDtoList.add(movieDto);
        });
        return movieDtoList;
    }

    public MovieDto getMovieById(Integer id) {
        MovieDto movieDto = new MovieDto();
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        Movie movie = optionalMovie.orElseThrow(() -> new ResourceNotFoundException("Movie", "movieId", id));
        movieDto.setMovieId(movie.getMovieId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setRating(movie.getRating());
        Set<Integer> categoriesIds = new HashSet<>();
        movie.getMovieCategories().forEach((item) -> {
            categoriesIds.add(item.getCategoryId());
        });
        movieDto.setCategories(categoriesIds);
        return movieDto;
    }

    public void deleteMovie(int id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        Movie movie = optionalMovie.orElseThrow(() -> new ResourceNotFoundException("Movie", "movieId", id));
        movieRepository.delete(movie);
    }

    public void updateMovie(MovieDto movieDto) {
        List<Category> categories = categoryRepository.findAllById(movieDto.getCategories());

        if (categories.size() > 0 && movieDto.getCategories().size() == categories.size()) {
            Optional<Movie> optionalMovie = movieRepository.findById(movieDto.getMovieId());
            Movie movie = optionalMovie.orElseThrow(() -> new ResourceNotFoundException("Movie", "movieId", movieDto.getMovieId()));
            movie.setTitle(movieDto.getTitle());
            movie.setRating(movieDto.getRating());

            Set<MovieCategory> movieCategories = new HashSet<>();
            for (Category category : categories) {
                MovieCategory movieCategory = new MovieCategory();
                movieCategory.setMovieId(movie.getMovieId());
                movieCategory.setCategoryId(category.getCategoryId());
                movieCategories.add(movieCategory);
            }
            movie.getMovieCategories().clear();
            movie.getMovieCategories().addAll(movieCategories);
            movieRepository.save(movie);
        } else {
            throw new ResourceNotFoundException("One or more of the categories", "categoriesId", movieDto.getCategories());
        }
    }
}
