package com.fm.recommender.api;

import com.fm.recommender.db.MovieInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RecommenderServiceApi {
    @Autowired
    private SessionFactory sessionFactory;

    public List<MovieInfo> getAllMovies() {
        Session session = sessionFactory.getCurrentSession();
        List<MovieInfo> allMovies = session.createQuery("from MovieInfo ", MovieInfo.class).getResultList();

        return allMovies;
    }
}
