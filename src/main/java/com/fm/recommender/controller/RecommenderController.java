package com.fm.recommender.controller;

import com.fm.recommender.db.MovieInfo;
import com.fm.recommender.service.RecommenderService;
import com.fm.recommender.service.impl.Movie;
import com.fm.recommender.service.impl.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommender")
public class RecommenderController {

    private final RecommenderService recommenderService;

    @GetMapping("/getTop")
    public List<MovieInfo> getTop(@RequestParam int limit, @RequestBody User user) {
        return recommenderService.getTop(user, limit);
    }

//    @PostMapping("/addMovie")
//    public void addMovie(@RequestBody MovieInfo movie) {
//        recommenderService.addMovie(movie);
//    }
}

