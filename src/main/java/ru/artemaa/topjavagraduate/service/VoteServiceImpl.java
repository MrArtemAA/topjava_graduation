package ru.artemaa.topjavagraduate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.dao.UserDao;
import ru.artemaa.topjavagraduate.dao.VoteDao;
import ru.artemaa.topjavagraduate.model.Vote;
import ru.artemaa.topjavagraduate.util.exception.LateVoteException;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFound;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class VoteServiceImpl implements VoteService {
    public static final LocalTime VOTE_DEADLINE = LocalTime.of(11, 00);

    private final VoteDao dao;
    private final UserDao userDao;
    private final RestaurantDao restaurantDao;

    @Autowired
    public VoteServiceImpl(VoteDao dao, UserDao userDao, RestaurantDao restaurantDao) {
        this.dao = dao;
        this.userDao = userDao;
        this.restaurantDao = restaurantDao;
    }

    /*@Override
    public Vote get(int userId, int restaurantId, LocalDate date) throws NotFoundException {
        return checkNotFound(dao.findByUserIdAndRestaurantIdAndDate(userId, restaurantId, date),
                String.format("vote not found for userId = %s, restaurantId = %s, date = %s",
                        userId,
                        restaurantId,
                        date.toString()));
    }*/

    /*@Override
    public Vote get(int id, int userId) throws NotFoundException {

        return checkNotFoundWithId(dao.get(id, userId), id);
    }*/

    //@Override
    private Vote save(int userId, int restaurantId) {
        Vote vote = new Vote();
        vote.setUser(userDao.getOne(userId));
        vote.setRestaurant(restaurantDao.getOne(restaurantId));
        return dao.save(vote);
    }

    //@Override
    private Vote update(Vote vote, int userId, int restaurantId) {
        //Vote vote = getByUser(userId, LocalDate.now());
        //vote.setTime(LocalTime.now());
        vote.setUser(userDao.getOne(userId));
        vote.setRestaurant(restaurantDao.getOne(restaurantId));
        return dao.save(vote);
    }

    @Override
    @Transactional
    public void vote(int userId, int restaurantId) throws LateVoteException {
        try {
            Vote vote = getByUser(userId, LocalDate.now());
            if (LocalTime.now().isAfter(VOTE_DEADLINE)) {
                throw new LateVoteException(VOTE_DEADLINE);
            }
            update(vote, userId, restaurantId);
        } catch (NotFoundException nfe) {
            save(userId, restaurantId);
        }
    }

    @Override
    public Vote getByUser(int userId, LocalDate date) throws NotFoundException {
        Assert.notNull(date, "date can't be null");
        return checkNotFound(dao.findByUserIdAndDate(userId, date),
                String.format("userId = %s on date = %s",
                        userId,
                        date.toString()));
    }

    /*@Override
    public List<Vote> getByUser(int userId) {
        return dao.findByUserId(userId);
    }

    @Override
    public List<Vote> getByRestaurant(int restaurantId, LocalDate date) {
        Assert.notNull(date, "date can't be null");
        return dao.findByRestaurantIdAndDate(restaurantId, date);
    }*/

}
