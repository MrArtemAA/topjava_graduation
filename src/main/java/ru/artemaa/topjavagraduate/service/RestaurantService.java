package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.List;

/**
 * @author MrArtemAA
 * 24.04.2017
 */
public interface RestaurantService {

    Restaurant get(int id) throws NotFoundException;

    Restaurant save(Restaurant entity);

    Restaurant update(Restaurant entity) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Restaurant> getAll();

}
