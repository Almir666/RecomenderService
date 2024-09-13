package com.fm.recommender.db;

import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.utils.Utils;
import jakarta.persistence.*;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
@Profile("dev")
public class SqlDb implements Db {

//TODO: Явная инициализация базы данных
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movie> getAllMovies() {
        Query query = entityManager.createQuery("from MovieInfo");
        List<MovieInfo> movieInfoList = query.getResultList();
        List<Movie> movieList = new ArrayList<>();
        for(MovieInfo m: movieInfoList) {
            movieList.add(Utils.fromMovies(m));
        }
        return movieList;
    }

    @Override
    public void saveMovie(Movie movie) {
        entityManager.merge(Utils.toMovieInfo(movie));
    }
}

