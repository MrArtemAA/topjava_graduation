package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.Vote;
import ru.artemaa.topjavagraduate.util.exception.LateVoteException;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;

/**
 * @author Artem Areshko
 * 24.04.2017
 */
public interface VoteService {

    //Vote get(int userId, int restaurantId, LocalDate date) throws NotFoundException;
    Vote vote(int userId, int restaurantId) throws LateVoteException;

    //Vote save(int userId, int restaurantId);

    //Vote update(int userId, int restaurantId) throws NotFoundException;

    Vote getByUser(int userId, LocalDate date) throws NotFoundException;

    //List<Vote> getByUser(int userId);

    //List<Vote> getByRestaurant(int restaurantId, LocalDate date);

}
