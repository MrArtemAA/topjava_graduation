package ru.artemaa.topjavagraduate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFoundWithId;

/**
 * @author Artem Areshko
 * 26.04.2017
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDao dao;

    @Autowired
    public RestaurantServiceImpl(RestaurantDao dao) {
        this.dao = dao;
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(dao.findOne(id), id);
    }

    @Override
    public Restaurant getWithDishes(int id, LocalDate menuDate) throws NotFoundException {
        return checkNotFoundWithId(dao.getWithDishes(id, menuDate), id);
    }

    @Override
    @CacheEvict(value = "restaurantsWithDishes", allEntries = true)
    public Restaurant save(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant can't be null");
        return dao.save(restaurant);
    }

    @Override
    @CacheEvict(value = "restaurantsWithDishes", allEntries = true)
    public void update(Restaurant restaurant) throws NotFoundException {
        Assert.notNull(restaurant, "restaurant can't be null");
        checkNotFoundWithId(dao.save(restaurant), restaurant.getId());
    }

    @Override
    @CacheEvict(value = "restaurantsWithDishes", allEntries = true)
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(dao.delete(id) != 0, id);
    }

    @Override
    public List<Restaurant> getAll() {
        return dao.findAll();
    }

    @Override
    @Cacheable("restaurantsWithDishes")
    public List<Restaurant> getAllWithDishes(LocalDate menuDate) {
        return dao.getAllWithDishes(menuDate);
    }

    @Override
    @CacheEvict(value = "restaurantsWithDishes", allEntries = true)
    public void evictCache() {}
}
