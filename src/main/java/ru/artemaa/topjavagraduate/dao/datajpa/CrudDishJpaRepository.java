package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.artemaa.topjavagraduate.model.Dish;

import java.time.LocalDate;
import java.util.List;

/**
 * MrArtemAA
 * 08.06.2017
 */
public interface CrudDishJpaRepository extends CrudBaseJpaRepository<Dish> {

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurantId AND d.date=:date ORDER BY d.name ASC")
    public List<Dish> getAll(@Param("restaurantId") int restaurantId, @Param("date") LocalDate date);

}
