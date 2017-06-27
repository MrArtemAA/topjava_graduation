package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.Vote;
import ru.artemaa.topjavagraduate.util.exception.LateVoteException;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Artem Areshko
 * 24.04.2017
 */
public interface VoteService {

    void vote(int userId, int restaurantId) throws LateVoteException;

    Vote getByUser(int userId, LocalDate date) throws NotFoundException;

    List<Vote> getByUser(int userId);

    List<Vote> getByRestaurant(int restaurantId, LocalDate date);

}
