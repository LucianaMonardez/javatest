package com.javatest.Movies.service;

import com.javatest.Movies.data.MovieRepository;
import com.javatest.Movies.model.Genre;
import com.javatest.Movies.model.Movie;

import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name){
        String NAME = name.toLowerCase();
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(NAME)).collect(Collectors.toList());
    }
}
