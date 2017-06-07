package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.Dish;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Areshko-AA on 24.04.2017.
 */
public interface DishService extends BaseService<Dish> {

    List<Dish> getAll(int restaurantId, LocalDate date);

    /**
     * @throws UnsupportedOperationException
     */
    @Override
    default List<Dish> getAll() {
        throw new UnsupportedOperationException();
    }

}
