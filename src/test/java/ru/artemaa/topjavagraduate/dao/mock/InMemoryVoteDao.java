package ru.artemaa.topjavagraduate.dao.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.artemaa.topjavagraduate.dao.VoteDao;
import ru.artemaa.topjavagraduate.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MrArtemAA
 * 03.05.2017
 */
@Repository
public class InMemoryVoteDao implements VoteDao {
    protected static final Logger LOG = LoggerFactory.getLogger(InMemoryBaseDao.class);

    protected Map<Integer, Map<Integer, Vote>> byId = new ConcurrentHashMap<>();
    private AtomicInteger counter;

    @Override
    public Vote save(Vote vote, int userId) {
        return null;
    }

    @Override
    public Vote get(int id, int userId) {
        return null;
    }

    @Override
    public List<Vote> getByUser(int userId) {
        return null;
    }

    @Override
    public List<Vote> getByUser(int userId, LocalDate date) {
        return null;
    }

    @Override
    public List<Vote> getByRestaurant(int restaurantId, LocalDate date) {
        return null;
    }

}
