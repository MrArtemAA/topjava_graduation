package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Artem Areshko
 * 24.04.2017
 */
public interface DishService {

    Dish get(int id, int restaurantId) throws NotFoundException;

    //Dish getWithRestaurant(int id, int restaurantid) throws NotFoundException;

    Dish save(Dish dish, int restaurantId);

    Dish update(Dish dish, int restaurantId) throws NotFoundException;

    void delete(int id, int restaurantId) throws NotFoundException;

    List<Dish> getAll(int restaurantId, LocalDate date);

}
