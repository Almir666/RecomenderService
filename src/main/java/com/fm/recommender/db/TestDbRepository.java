package com.fm.recommender.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDbRepository {
    @Autowired
    private EntityManager entityManager;

    public List<TestMovie> getAllMovies() {
        Query query = entityManager.createQuery("from TestMovie ");
        List<TestMovie> allMovies = query.getResultList();
        return allMovies;
    }

}
