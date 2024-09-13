package com.fm.recommender.service;

import com.fm.recommender.db.MovieInfo;
import com.fm.recommender.service.impl.Movie;
import com.fm.recommender.service.impl.User;

import java.util.List;

/**
 * Сервис служит для ранджирования фильмов для пользовотеля...
 */
public interface RecommenderService {
    /**
     * Получает топ фильмов для конкретного юзера
     *
     * @param user desctiption...
     * @param limit ...
     * @return возвращает список фильмов...
     */


    //TODO продумать нейминг
    List<MovieInfo> getTop(User user, int limit);


//    void addMovie(MovieInfo movie);
}
