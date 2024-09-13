package com.fm.recommender.core.impl;

import com.fm.recommender.core.Scorer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class ScorerImpl implements Scorer<Movie, User> {

    private final static Logger log = LoggerFactory.getLogger(ScorerImpl.class);
    @Override
    public double getScore(Movie movie, User user) {
        double[] movieEmbedding = movie.getEmbedding();
        double[] userEmbedding  = user.getEmbedding();
        if (movieEmbedding.length != userEmbedding.length) {
            log.warn("user embedding and movie embedding have different sizes");
        }
        double score = 0;
        for (int i = 0; i < Math.min(movieEmbedding.length, userEmbedding.length); i++) {
            score += movieEmbedding[i] * userEmbedding[i];
        }
        return score;
    }
}