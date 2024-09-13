package com.fm.recommender.api;

import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.core.impl.RecommenderServiceImpl;
import com.fm.recommender.core.impl.ScorerImpl;
import com.fm.recommender.core.impl.User;
import com.fm.recommender.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommenderServiceApi {
    @Autowired
    private Db dataBase;
    @Autowired
    private ScorerImpl scorer;
    @Autowired
    private RecommenderServiceImpl recommenderService = new RecommenderServiceImpl(scorer, dataBase);


    @GetMapping("/recommender/getTop")

    public List<Movie> getTop(@RequestParam int limit, @RequestBody User user) {
        return recommenderService.getTop(user, limit);
    }

    @PostMapping("recommender/addMovie")
    public void addMovie(@RequestBody Movie movie) {
        recommenderService.addMovie(movie);
    }
}

