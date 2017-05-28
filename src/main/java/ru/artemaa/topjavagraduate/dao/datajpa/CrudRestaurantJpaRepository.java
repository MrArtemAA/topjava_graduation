package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.artemaa.topjavagraduate.model.Restaurant;

/**
 * MrArtemAA
 * 29.05.2017
 */
public interface CrudRestaurantJpaRepository extends CrudBaseJpaRepository<Restaurant> {

    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

}
