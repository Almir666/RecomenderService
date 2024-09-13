package com.fm.recommender.core;

public interface Scorer<Movie, User> {
    double getScore(Movie movie, User user);
}
