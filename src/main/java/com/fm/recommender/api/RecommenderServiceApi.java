package com.fm.recommender.api;

import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.core.impl.RecommenderServiceImpl;
import com.fm.recommender.core.impl.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommenderServiceApi {

    private RecommenderServiceImpl recommenderService;

    @GetMapping("/recommender/getTop")
    public List<Movie> getTop(User user, int limit) {
        return recommenderService.getTop(user, limit);
    }

    @PostMapping("recommender/addMovie")
    public void addMovie(@RequestBody String id, String title, String snippet, double[] embedding) {
        Movie newMovie = new Movie(id, title, snippet, embedding);
        recommenderService.addMovie(newMovie);
    }
}
