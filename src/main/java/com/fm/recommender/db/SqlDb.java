package com.fm.recommender.db;

import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class SqlDb implements Db{
    private EntityManager entityManager;
    @Override
    public List<Movie> getAllMovies() {
        Query query = entityManager.createQuery("from MovieInfo ");
        List<MovieInfo> movieInfoList = query.getResultList();
        List<Movie> movieList = new ArrayList<>();

        return null;
    }

    @Override
    public void saveMovie(Movie movie) {
        entityManager.merge(Utils.toMovieInfo(movie));
    }
}
