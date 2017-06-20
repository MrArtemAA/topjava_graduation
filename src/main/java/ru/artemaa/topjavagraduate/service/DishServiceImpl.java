package ru.artemaa.topjavagraduate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.artemaa.topjavagraduate.dao.DishDao;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFoundWithId;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class DishServiceImpl implements DishService {
    private final DishDao dao;
    private final RestaurantDao restaurantDao;

    @Autowired
    public DishServiceImpl(DishDao dao, RestaurantDao restaurantDao) {
        this.dao = dao;
        this.restaurantDao = restaurantDao;
    }

    @Override
    public Dish get(int id, int restaurantId) throws NotFoundException {
        Dish dish = dao.findOne(id);
        return checkNotFoundWithId(dish != null && dish.getRestaurant().getId() == restaurantId ? dish : null, id);
    }

    @Override
    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish can't be null");
        dish.setRestaurant(restaurantDao.getOne(restaurantId));
        return dao.save(dish);
    }

    @Override
    @Transactional
    public Dish update(Dish dish, int restaurantId) throws NotFoundException {
        Assert.notNull(dish, "dish can't be null");
        get(dish.getId(), restaurantId);
        return save(dish, restaurantId);
    }

    @Override
    public void delete(int id, int restaurantId) throws NotFoundException {
        checkNotFoundWithId(dao.delete(id, restaurantId) != 0, id);
    }

    @Override
    public List<Dish> getAll(int restaurantId, LocalDate date) {
        return dao.findAllByRestaurantIdAndDateOrderByName(restaurantId, date);
        //return dao.findAllByRestaurantIdOrderByName(restaurantId);
    }

}
