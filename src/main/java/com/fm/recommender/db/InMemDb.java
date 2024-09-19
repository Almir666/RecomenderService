package com.fm.recommender.db;

import com.fm.recommender.core.impl.Movie;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Profile("test")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class InMemDb implements Db {
    private final Map<String, Movie> movies = new HashMap<>();
    @Override
    public List<Movie> getAllMovies() {
        return movies.values().stream().toList();
    }

    @Override
    public void saveMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }

}
