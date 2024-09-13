package com.fm.recommender.api;

import com.fm.recommender.core.RecommenderService;
import com.fm.recommender.core.Scorer;
import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.core.impl.RecommenderServiceImpl;
import com.fm.recommender.core.impl.ScorerImpl;
import com.fm.recommender.core.impl.User;
import com.fm.recommender.db.*;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Profile("dev")
@RequestMapping("/api")
public class RecommenderServiceApi {
    private final RecommenderService<Movie, User> recommenderService;

    public RecommenderServiceApi(RecommenderService<Movie, User> recommenderService) {
        this.recommenderService = recommenderService;
    }

    @GetMapping("/recommender/getTop")

    public List<Movie> getTop(@RequestParam int limit, @RequestBody User user) {
        return recommenderService.getTop(user, limit);
    }

    @PostMapping("recommender/addMovie")
    public void addMovie(@RequestBody Movie movie) {
        recommenderService.addMovie(movie);
    }
}
