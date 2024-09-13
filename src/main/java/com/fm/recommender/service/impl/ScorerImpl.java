//package com.fm.recommender.service.impl;
//
//import com.fm.recommender.service.Scorer;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ScorerImpl implements Scorer<Movie, User> {
//    @Override
//    public double getScore(Movie movie, User user) {
//        double[] movieEmbedding = movie.getEmbedding();
//        double[] userEmbedding  = user.getEmbedding();
//        if (movieEmbedding.length != userEmbedding.length) {
//            throw new RuntimeException("user embedding and movie embedding have different sizes");
//        }
//        double score = 0;
//        for (int i = 0; i < movieEmbedding.length; i++) {
//            score += movieEmbedding[i] * userEmbedding[i];
//        }
//        return score;
//    }
//}
