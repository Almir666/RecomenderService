package com.fm.recommender.db;

import com.fm.recommender.service.impl.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Db extends JpaRepository<MovieInfo, Long> {

//    List<MovieInfo> getAllMovies();
//    void saveMovie(MovieInfo movie);
}
