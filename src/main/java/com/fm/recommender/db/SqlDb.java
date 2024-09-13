//package com.fm.recommender.db;
//
//import com.fm.recommender.service.impl.Movie;
//import com.fm.recommender.utils.Utils;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//
//@Repository
//@Transactional
//public class SqlDb implements Db {
//
//
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Movie> getAllMovies() {
//        Query query = entityManager.createQuery("from MovieInfo ");
//        List<MovieInfo> movieInfoList = query.getResultList();
//        List<Movie> movieList = new ArrayList<>();
//        for(MovieInfo m: movieInfoList) {
//            movieList.add(Utils.fromMovies(m));
//        }
//        return movieList;
//    }
//
//    @Override
//    public void saveMovie(Movie movie) {
//        entityManager.merge(Utils.toMovieInfo(movie));
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Movie> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Movie> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<Movie> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Movie getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public Movie getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public Movie getReferenceById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends Movie> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Movie> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Movie> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Movie> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Movie> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Movie> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Movie, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public <S extends Movie> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Movie> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<Movie> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public List<Movie> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Movie> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Movie entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Movie> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<Movie> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Movie> findAll(Pageable pageable) {
//        return null;
//    }
//}
