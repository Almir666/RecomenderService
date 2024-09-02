package com.fm.recommender.impl;

import com.fm.recommender.RecommenderService;
import com.fm.recommender.Scorer;

import java.util.*;
import java.util.stream.Collectors;


public class RecommenderServiceImpl implements RecommenderService<Movie, User> {
    private InMemDb db = new InMemDb();
    final Scorer<Movie, User> scorer = new ScorerImpl();
    private static RecommenderServiceImpl instance;
    private RecommenderServiceImpl(){}
    public static RecommenderServiceImpl getInstance() {
        if(instance == null) {
            instance = new RecommenderServiceImpl();
        }
        return instance;
    }
    @Override
    public List<Movie> getTop(User user, int limit) {
        List<Movie> listMovies = db.getAllMovies();
        int currentListSize = db.getAllMovies().size();
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

