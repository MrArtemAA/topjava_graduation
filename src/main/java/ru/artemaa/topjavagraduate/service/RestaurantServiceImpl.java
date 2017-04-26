package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.dao.BaseDao;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;

/**
 * Created by Areshko-AA on 26.04.2017.
 */
public class RestaurantServiceImpl extends BaseServiceImpl<Restaurant, RestaurantDao> implements RestaurantService {

    public RestaurantServiceImpl(RestaurantDao dao) {
        super(dao);
    }

}
