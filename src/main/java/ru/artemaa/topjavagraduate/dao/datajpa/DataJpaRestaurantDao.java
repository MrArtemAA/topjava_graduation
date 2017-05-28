package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;

import java.util.List;

/**
 * @author MrArtemAA
 * 18.05.2017
 */
@Repository
public class DataJpaRestaurantDao extends DataJpaBaseDao<Restaurant> implements RestaurantDao {

    @Override
    protected Sort getSort() {
        return SORT_BY_NAME;
    }

}
