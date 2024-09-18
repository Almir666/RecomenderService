package com.fm.recommender.api;

import com.fm.recommender.core.RecommenderService;
import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.core.impl.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommender")
public class RecommenderServiceApi {
    private final RecommenderService<Movie, User> recommenderService;

    public RecommenderServiceApi(RecommenderService<Movie, User> recommenderService) {
        this.recommenderService = recommenderService;
    }

    @GetMapping("/getTop")

    public List<Movie> getTop(@RequestParam int limit, @RequestBody User user) {
        return recommenderService.getTop(user, limit);
    }

    @PostMapping("/addMovie")
    public void addMovie(@RequestBody Movie movie) {
        recommenderService.addMovie(movie);
    }
}
