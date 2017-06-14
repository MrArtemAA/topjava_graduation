package ru.artemaa.topjavagraduate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.List;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFoundWithId;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    protected RestaurantDao dao;

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(dao.findOne(id), id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant can't be null");
        return dao.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) throws NotFoundException {
        Assert.notNull(restaurant, "restaurant can't be null");
        return checkNotFoundWithId(dao.save(restaurant), restaurant.getId());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(dao.delete(id) != 0, id);
    }

    @Override
    public List<Restaurant> getAll() {
        return dao.findAll();
    }

}
