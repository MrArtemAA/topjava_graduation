package ru.artemaa.topjavagraduate.service;

import org.springframework.stereotype.Service;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class RestaurantServiceImpl extends BaseServiceImpl<Restaurant, RestaurantDao> implements RestaurantService {

    public RestaurantServiceImpl(RestaurantDao dao) {
        super(dao);
    }

}
