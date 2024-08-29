package com.fm.recommender.impl;

import com.fm.recommender.RecommenderService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RecommenderServiceImplTest {
    @Test
    void testGetTop() {
        Movie movie1 = new Movie(
                UUID.randomUUID().toString(),
                "Twilight",
                "When Bella Swan moves to a small town in the Pacific Northwest, she falls in love with Edward Cullen, a mysterious classmate who reveals himself to be a 108-year-old vampire.",
                new double[] {1., 2.}
        );
        Movie movie2 = new Movie(
                UUID.randomUUID().toString(),
                "Lord of the rings",
                "In the Second Age of Middle-earth, the lords of Elves, Dwarves, and Men are given Rings of Power. Unbeknownst to them, the Dark Lord Sauron forges the One Ring in Mount Doom, instilling into it a great part of his power to dominate the other Rings and conquer Middle-earth.",
                new double[] {5., 6.}
        );
        Movie movie3 = new Movie(
                UUID.randomUUID().toString(),
                "Chainsaw Man",
                "Chainsaw Man follows the story of Denji, an impoverished teenager who makes a contract that fuses his body with that of a dog-like Devil named Pochita, granting him the ability to transform parts of his body into chainsaws.",
                new double[] {7., 8.}
        );
        User user1 = new User(
                UUID.randomUUID().toString(),
                "Maxim",
                new double[] {2., 3.}
        );
        User user2 = new User(
                UUID.randomUUID().toString(),
                "Almir",
                new double[] {4., 3.}
        );
        final RecommenderService<Movie, User> recomender = new RecommenderServiceImpl();
    }
}
