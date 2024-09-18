package com.fm.recommender.db;

import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.utils.Utils;
import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@Profile("dev")
public class SqlDb implements Db {
    @PersistenceContext
    private EntityManager entityManager;

//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.fm.recommender.db.MovieInfo");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();

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

