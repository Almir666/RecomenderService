package com.fm.recommender.service.impl;

import com.fm.recommender.db.MovieInfo;
import com.fm.recommender.service.RecommenderService;
import com.fm.recommender.service.Scorer;
import com.fm.recommender.db.Db;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommenderServiceImpl implements RecommenderService {
    private final Db db;

    //TODO вынести в дргуой сервис и отдельынй контроллер
    @Override
    public List<MovieInfo> getTop(User user, int limit) {
//        init();
//        listMovies = db.getAllMovies();
//        int currentListSize = listMovies.size();
//        List<Movie> compileMoviesForUser = listMovies.stream().map(movie -> new CreatePair(movie,scorer.getScore(movie, user))).sorted(new Comparator<CreatePair>() {
//            @Override
//            public int compare(CreatePair o1, CreatePair o2) {
//                if (o1.getScore() == o2.getScore()) {
//                    return 0;
//                } else if (o1.getScore() > o2.getScore()) {
//                    return -1;
//                } else return 1;
//            }
//        }).map(m -> m.getMovie()).collect(Collectors.toList());
//
//        if (currentListSize < limit) {
//            return compileMoviesForUser;
//        }
//        return compileMoviesForUser.subList(0, limit);
        return db.findAll();
    }
//    @Override
//    public void addMovie(MovieInfo movie) {
//        db.saveMovie(movie);
//    }

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

