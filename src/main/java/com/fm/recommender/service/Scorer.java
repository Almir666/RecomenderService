package com.fm.recommender.service;

public interface Scorer<Movie, User> {
    double getScore(Movie movie, User user);
}
