package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.artemaa.topjavagraduate.dao.DishDao;
import ru.artemaa.topjavagraduate.model.Dish;

import java.time.LocalDate;
import java.util.List;

/**
 * MrArtemAA
 * 08.06.2017
 */
@Repository
public class DataJpaDishDao extends DataJpaBaseDao<Dish, CrudDishJpaRepository> implements DishDao {

    @Override
    public List<Dish> getAll(int restaurantId, LocalDate date) {
        return crudJpaRepository.getAll(restaurantId, date);
    }

    @Override
    protected Sort getSort() {
        return null;
    }
}
