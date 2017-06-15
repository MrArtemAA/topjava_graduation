package ru.artemaa.topjavagraduate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.artemaa.topjavagraduate.model.Dish;

import java.time.LocalDate;
import java.util.List;

/**
 * MrArtemAA
 * 24.04.2017
 */
@Repository
@Transactional(readOnly = true)
public interface DishDao extends JpaRepository<Dish, Integer> {

    @Override
    @Transactional
    Dish save(Dish s);

    @Override
    Dish findOne(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId")
    int delete(@Param("id") int id, @Param("restaurantId") int restaurantId);

    List<Dish> findAllByRestaurantIdAndDateOrderByName(int restaurantId, LocalDate date);

    List<Dish> findAllByRestaurantIdOrderByName(int restaurantId);

}
