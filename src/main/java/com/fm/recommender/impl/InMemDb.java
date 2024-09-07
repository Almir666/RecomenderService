package com.fm.recommender.impl;

import com.fm.recommender.Db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
