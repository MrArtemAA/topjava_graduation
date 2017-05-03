package ru.artemaa.topjavagraduate.service;

import org.springframework.stereotype.Service;
import ru.artemaa.topjavagraduate.dao.DishDao;
import ru.artemaa.topjavagraduate.model.Dish;

import java.util.List;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class DishServiceImpl extends BaseServiceImpl<Dish, DishDao> implements DishService {

    public DishServiceImpl(DishDao dao) {
        super(dao);
    }

    @Override
    public List<Dish> getAll(int restaurantId) {
        return dao.getAll(restaurantId);
    }

}
