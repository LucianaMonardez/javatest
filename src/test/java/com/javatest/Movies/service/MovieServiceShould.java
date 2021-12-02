package com.javatest.Movies.service;

import com.javatest.Movies.data.MovieRepository;
import com.javatest.Movies.model.Genre;
import com.javatest.Movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Contains;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

        Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "IT", 135, Genre.Horror),
                new Movie(2, "Joker", 162, Genre.Drama),
                new Movie(3, "The Mask", 101, Genre.Comedy),
                new Movie(4, "Parasite", 132, Genre.Thriller),
                new Movie(5, "Venom", 97, Genre.Action)
        ));
    }
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

    @Test
    public void return_movies_by_genre() {

        movieService = new MovieService(movieRepository);
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.Horror);
        assertThat(movies.stream().map(movie -> movie.getId()).collect(Collectors.toList()), CoreMatchers.is(Arrays.asList(1)));
    }

    @Test
    public void return_movies_by_name() {
        movieService = new MovieService(movieRepository);
        Collection<Movie> movies = movieService.findMoviesByName("JOKER");
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2)));
    }

    @Test
    public void return_movies_by_length() {
        movieService = new MovieService(movieRepository);
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 5)));
    }
    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}