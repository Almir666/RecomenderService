package com.fm.recommender.core;

import java.util.List;

public interface RecommenderService<Movie, User> {
    List<Movie> getTop(User user, int limit);
    void addMovie(Movie movie);
}
