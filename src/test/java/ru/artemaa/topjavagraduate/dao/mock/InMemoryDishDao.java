package ru.artemaa.topjavagraduate.dao.mock;

import org.springframework.stereotype.Repository;
import ru.artemaa.topjavagraduate.dao.DishDao;
import ru.artemaa.topjavagraduate.model.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * MrArtemAA
 * 03.05.2017
 */
@Repository
public class InMemoryDishDao extends InMemoryBaseDao<Dish> implements DishDao {

    @Override
    public List<Dish> getAll(int restaurantId) {
        return byId.values().stream()
                .filter(dish -> restaurantId == dish.getRestaurant().getId())
                .sorted(getComparator())
                .collect(Collectors.toList());
    }

    @Override
    protected AtomicInteger getCounter() {
        return new AtomicInteger(10);
    }

    @Override
    protected Comparator<Dish> getComparator() {
        return Comparator.comparing(Dish::getName);
    }

}
