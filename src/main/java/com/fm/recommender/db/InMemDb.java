package com.fm.recommender.db;

import com.fm.recommender.core.impl.Movie;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Profile("test")
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
