package com.fm.recommender.impl;

import com.fm.recommender.RecommenderService;

import java.util.List;

public class RecommenderServiceImpl implements RecommenderService<Movie, User> {

    @Override
    public List<Movie> getTop(User user, int limit) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void addMovie(Movie movie) {
        throw new UnsupportedOperationException("TODO");
    }
}
