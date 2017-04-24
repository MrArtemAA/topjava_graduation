package ru.artemaa.topjavagraduate.dao;

import ru.artemaa.topjavagraduate.model.Vote;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Areshko-AA on 24.04.2017.
 */
public interface VoteDao {

    Vote save(Vote vote, int userId);

    /**
     *
     * @param id
     * @param userId
     * @return null if not found
     */
    Vote get(int id, int userId);

    List<Vote> getByUser(int userId);

    List<Vote> getByUser(int userId, LocalDate date);

    List<Vote> getByRestaurant(int restaurantId, LocalDate date);

}
