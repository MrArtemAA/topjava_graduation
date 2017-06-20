package ru.artemaa.topjavagraduate.util;

import org.springframework.data.domain.Sort;
import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.to.DishTo;

/**
 * @author MrArtemAA
 *         14.06.2017
 */
public class ModelUtil {

    private ModelUtil() {
    }

    public static final Sort SORT_BY_NAME = new Sort("name");
    public static final Sort SORT_BY_NAME_EMAIL = new Sort("name", "email");

    public static Dish createFromTo(DishTo dishTo) {
        return new Dish(dishTo.getId(), dishTo.getName(), null, dishTo.getPrice());
    }

    public static DishTo createFromEntity(Dish dish) {
        return new DishTo(dish.getId(), dish.getName(), dish.getPrice());
    }

}
