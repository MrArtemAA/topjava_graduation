package ru.artemaa.topjavagraduate.dao;

import ru.artemaa.topjavagraduate.model.Dish;

import java.util.List;

/**
 * Created by Areshko-AA on 24.04.2017.
 */
public interface DishDao extends BaseDao<Dish> {

    List<Dish> getAll(int restaurantId);

    /**
     * @throws UnsupportedOperationException
     */
    @Override
    List<Dish> getAll();
}
