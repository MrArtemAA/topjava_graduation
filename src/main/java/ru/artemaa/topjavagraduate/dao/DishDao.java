package ru.artemaa.topjavagraduate.dao;

import ru.artemaa.topjavagraduate.model.Dish;

import java.time.LocalDate;
import java.util.List;

/**
 * MrArtemAA
 * 24.04.2017
 */
public interface DishDao extends BaseDao<Dish> {

    List<Dish> getAll(int restaurantId, LocalDate date);

    /**
     * @throws UnsupportedOperationException
     */
    @Override
    default List<Dish> getAll() {
        throw new UnsupportedOperationException();
    }
}
