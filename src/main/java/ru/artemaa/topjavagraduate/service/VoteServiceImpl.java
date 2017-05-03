package ru.artemaa.topjavagraduate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artemaa.topjavagraduate.dao.VoteDao;
import ru.artemaa.topjavagraduate.model.Vote;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFoundWithId;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDao dao;

    public VoteServiceImpl(VoteDao dao) {
        this.dao = dao;
    }

    @Override
    public Vote get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(dao.get(id, userId), id);
    }

    @Override
    public Vote save(Vote vote, int userId) {
        // TODO Assert vote not null
        return dao.save(vote, userId);
    }

    @Override
    public Vote update(Vote vote, int userId) throws NotFoundException {
        // TODO Assert vote not null
        return checkNotFoundWithId(dao.save(vote, userId), vote.getId());
    }

    @Override
    public List<Vote> getByUser(int userId) {
        return dao.getByUser(userId);
    }

    @Override
    public List<Vote> getByUser(int userId, LocalDate date) {
        // TODO Assert date not null
        return dao.getByUser(userId, date);
    }

    @Override
    public List<Vote> getByRestaurant(int restaurantId, LocalDate date) {
        // TODO Assert date not null
        return dao.getByRestaurant(restaurantId, date);
    }

}
