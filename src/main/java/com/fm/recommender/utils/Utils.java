package com.fm.recommender.utils;

import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.db.MovieInfo;


public class Utils {
    public static Movie fromMovies(MovieInfo movieInfo) {
        return new Movie(movieInfo.getId(), movieInfo.getTitle(), movieInfo.getSnippet(), movieInfo.getEmbedding());
    }

    public static MovieInfo toMovieInfo(Movie movie) {
        return new MovieInfo(movie.getId(), movie.getTitle(), movie.getSnippet(), movie.getEmbedding());
    }
}
