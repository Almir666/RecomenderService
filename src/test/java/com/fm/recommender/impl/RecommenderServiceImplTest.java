package com.fm.recommender.impl;

import com.fm.recommender.service.*;
import com.fm.recommender.service.impl.Movie;
import com.fm.recommender.service.impl.RecommenderServiceImpl;
import com.fm.recommender.service.impl.ScorerImpl;
import com.fm.recommender.service.impl.User;
import com.fm.recommender.db.Db;
import com.fm.recommender.db.InMemDb;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class RecommenderServiceImplTest {

    @Test
    void testGetTopOverLimit() {
        Movie movie1 = new Movie(
                UUID.randomUUID().toString(),
                "Twilight",
                "When Bella Swan moves to a small town in the Pacific Northwest, she falls in love with Edward Cullen, a mysterious classmate who reveals himself to be a 108-year-old vampire.",
                new double[]{1., 2.}
        );
        Movie movie2 = new Movie(
                UUID.randomUUID().toString(),
                "Lord of the rings",
                "In the Second Age of Middle-earth, the lords of Elves, Dwarves, and Men are given Rings of Power. Unbeknownst to them, the Dark Lord Sauron forges the One Ring in Mount Doom, instilling into it a great part of his power to dominate the other Rings and conquer Middle-earth.",
                new double[]{5., 6.}
        );
        Movie movie3 = new Movie(
                UUID.randomUUID().toString(),
                "Chainsaw Man",
                "Chainsaw Man follows the story of Denji, an impoverished teenager who makes a contract that fuses his body with that of a dog-like Devil named Pochita, granting him the ability to transform parts of his body into chainsaws.",
                new double[]{3., 2.}
        );
        User user = new User(
                UUID.randomUUID().toString(),
                "Almir",
                new double[]{1., 2.}
        );
        final Db db = new InMemDb();
        final Scorer<Movie, User> scorer = new ScorerImpl();
        db.saveMovie(movie3);
        db.saveMovie(movie2);
        db.saveMovie(movie1);

        final RecommenderService<Movie, User> recomender = new RecommenderServiceImpl(scorer, db);
        List<Movie> actual = new ArrayList<>();
        actual.add(movie2);
        actual.add(movie3);
        actual.add(movie1);
        List<Movie> expected = recomender.getTop(user, 5);
        assertIterableEquals(expected, actual);
    }
    @Test
    void testGetTopLessLimit() {
        Movie movie1 = new Movie(
                UUID.randomUUID().toString(),
                "Twilight",
                "When Bella Swan moves to a small town in the Pacific Northwest, she falls in love with Edward Cullen, a mysterious classmate who reveals himself to be a 108-year-old vampire.",
                new double[]{1., 2.}
        );
        Movie movie2 = new Movie(
                UUID.randomUUID().toString(),
                "Lord of the rings",
                "In the Second Age of Middle-earth, the lords of Elves, Dwarves, and Men are given Rings of Power. Unbeknownst to them, the Dark Lord Sauron forges the One Ring in Mount Doom, instilling into it a great part of his power to dominate the other Rings and conquer Middle-earth.",
                new double[]{5., 6.}
        );
        Movie movie3 = new Movie(
                UUID.randomUUID().toString(),
                "Chainsaw Man",
                "Chainsaw Man follows the story of Denji, an impoverished teenager who makes a contract that fuses his body with that of a dog-like Devil named Pochita, granting him the ability to transform parts of his body into chainsaws.",
                new double[]{3., 2.}
        );
        User user = new User(
                UUID.randomUUID().toString(),
                "Almir",
                new double[]{1., 2.}
        );
        final Db db = new InMemDb();
        final Scorer<Movie, User> scorer = new ScorerImpl();
        db.saveMovie(movie3);
        db.saveMovie(movie2);
        db.saveMovie(movie1);

        final RecommenderService<Movie, User> recomender = new RecommenderServiceImpl(scorer, db);
        List<Movie> actual = new ArrayList<>();
        actual.add(movie2);
        actual.add(movie3);
        List<Movie> expected = recomender.getTop(user, 2);
        assertIterableEquals(expected, actual);
    }
}
