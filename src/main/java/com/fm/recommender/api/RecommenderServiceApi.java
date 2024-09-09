package com.fm.recommender.api;

import com.fm.recommender.core.impl.Movie;
import com.fm.recommender.core.impl.RecommenderServiceImpl;
import com.fm.recommender.core.impl.User;
import com.fm.recommender.db.MovieInfo;
import com.fm.recommender.db.TestDbRepository;
import com.fm.recommender.db.TestMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommenderServiceApi {
    private RecommenderServiceImpl recommenderService;
    // для тестирования подключения к бд
    //-----------------------------------
    @Autowired
    private TestDbRepository test;
    @GetMapping("/recommender/test")
    public List<TestMovie> testMethod() {
        return test.getAllMovies();
    }
    //-----------------------------------

    @GetMapping("/recommender/getTop/{limit}")

    public List<Movie> getTop(@PathVariable int limit, @RequestBody User user) {
        return recommenderService.getTop(user, limit);
    }

    @PostMapping("recommender/addMovie")
    public void addMovie(@RequestBody String id, String title, String snippet, double[] embedding) {
        Movie newMovie = new Movie(id, title, snippet, embedding);
        recommenderService.addMovie(newMovie);
    }
}
