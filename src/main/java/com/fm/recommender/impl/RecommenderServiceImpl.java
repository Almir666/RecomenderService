package com.fm.recommender.impl;

import com.fm.recommender.Db;
import com.fm.recommender.RecommenderService;
import com.fm.recommender.Scorer;

import java.util.*;
import java.util.stream.Collectors;


public class RecommenderServiceImpl implements RecommenderService<Movie, User> {
    private final Scorer<Movie, User> scorer;
    private final Db db;
    private boolean initialized = false;
    private List<Movie> listMovies;
    void init() {
        if(!initialized) {
            initialized = true;
            listMovies = db.getAllMovies();
        }
    }
    public RecommenderServiceImpl(Scorer<Movie, User> scorer, Db db) {
        this.scorer = scorer;
        this.db = db;
    }
    @Override
    public List<Movie> getTop(User user, int limit) {
        init();
        listMovies = db.getAllMovies();
        int currentListSize = listMovies.size();
        List<Movie> compileMoviesForUser = listMovies.stream().map(movie -> new CreatePair(movie,scorer.getScore(movie, user))).sorted(new Comparator<CreatePair>() {
            @Override
            public int compare(CreatePair o1, CreatePair o2) {
                if (o1.getScore() == o2.getScore()) {
                    return 0;
                } else if (o1.getScore() > o2.getScore()) {
                    return -1;
                } else return 1;
            }
        }).map(m -> m.getMovie()).collect(Collectors.toList());

        if (currentListSize < limit) {
            return compileMoviesForUser;
        }
        return compileMoviesForUser.subList(0, limit);
    }
    @Override
    public void addMovie(Movie movie) {
        init();
        db.saveMovie(movie);
    }

    static class CreatePair {
        private Movie movie;
        private double score;
        CreatePair(Movie movie, double score) {
            this.movie = movie;
            this.score = score;
        }
        public double getScore() {
            return score;
        }
        public Movie getMovie() {
            return movie;
        }
    }
}

