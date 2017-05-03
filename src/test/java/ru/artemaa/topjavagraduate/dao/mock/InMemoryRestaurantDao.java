package ru.artemaa.topjavagraduate.dao.mock;

import org.springframework.stereotype.Repository;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.artemaa.topjavagraduate.RestaurantTestData.RESTAURANTS;

/**
 * MrArtemAA
 * 03.05.2017
 */
@Repository
public class InMemoryRestaurantDao extends InMemoryBaseDao<Restaurant> implements RestaurantDao {

    public InMemoryRestaurantDao() {
        for (Restaurant restaurant : RESTAURANTS) {
            byId.put(restaurant.getId(), restaurant);
        }
    }

    @Override
    protected AtomicInteger getCounter() {
        return new AtomicInteger(2);
    }

    @Override
    protected Comparator<Restaurant> getComparator() {
        return Comparator.comparing(Restaurant::getName);
    }
}
