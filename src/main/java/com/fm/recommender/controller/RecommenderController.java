package com.fm.recommender.controller;

import com.fm.recommender.api.RecommenderServiceApi;
import com.fm.recommender.db.MovieInfo;
import com.fm.recommender.impl.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommenderController {
    @Autowired
    private RecommenderServiceApi recommenderServiceApi;

    @GetMapping("/movies")
    public MovieInfo getAllMovies() {
//        List<MovieInfo> allMovies = recommenderServiceApi.getAllMovies();
        return new MovieInfo(1, "sdfsf", "sjghsfgsghiufhefiu", 5.5);
    }
}
