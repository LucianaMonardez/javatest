package com.javatest.Movies.data;

import com.javatest.Movies.model.Genre;
import com.javatest.Movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private static DataSource dataSource;
    private MovieRepositoryJdbc movieRepository;

    @Before
    public void setUp() throws Exception {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepository.findAll();

        assertThat( movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.Action),
                new Movie(2, "Memento", 113, Genre.Thriller),
                new Movie(3, "Matrix", 136, Genre.Action)
        )) );
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(1);
        assertThat(movie, is(new Movie(1,"Dark Knight",152,Genre.Action)));
    }


    @Test
    public void insert_movie() {
        Movie movie = new Movie("Iron Man", 130, Genre.Action);
        movieRepository.saveOrUpdate(movie);
        Movie movie1 = movieRepository.findById(4);

        assertThat(movie1, is(new Movie(4,"Iron Man", 130, Genre.Action ) ) );
    }



    @After
    public void tearDown() throws Exception {

        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");

    }
}