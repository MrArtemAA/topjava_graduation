package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.Vote;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Areshko-AA on 24.04.2017.
 */
public interface VoteService {

    Vote get(int id, int userId) throws NotFoundException;

    Vote save(Vote vote, int userId);

    Vote update(Vote vote, int userId) throws NotFoundException;

    List<Vote> getByUser(int userId);

    List<Vote> getByUser(int userId, LocalDate date);

    List<Vote> getByRestaurant(int restaurantId, LocalDate date);

}
