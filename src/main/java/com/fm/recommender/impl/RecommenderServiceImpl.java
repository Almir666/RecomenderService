package com.fm.recommender.impl;

import com.fm.recommender.RecommenderService;
import com.fm.recommender.Scorer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RecommenderServiceImpl implements RecommenderService<Movie, User> {

    final Scorer<Movie, User> scorer = new ScorerImpl();
    private List<Movie> listMovies;
    @Override
    public List<Movie> getTop(User user, int limit) {
        listMovies.stream().sorted(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                double scoreMovie1 = scorer.getScore(o1, user);
                double scoreMovie2 = scorer.getScore(o2, user);
                if (scoreMovie1 == scoreMovie2) {
                    return 0;
                }
                else if (scoreMovie1 < scoreMovie2) {
                    return -1;
                }
                else return 1;
            }
        }).collect(Collectors.toList());
        return listMovies;
    }
    @Override
    public void addMovie(Movie movie) {
        listMovies.add(movie);
    }
}

