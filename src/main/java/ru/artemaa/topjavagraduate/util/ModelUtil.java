package ru.artemaa.topjavagraduate.util;

import org.springframework.data.domain.Sort;
import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.model.Role;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.to.DishTo;
import ru.artemaa.topjavagraduate.to.UserTo;

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

    /*public static Dish updateFromTo(DishTo dishTo) {

    }*/

    /*public static DishTo createFromEntity(Dish dish) {
        return new DishTo(dish.getId(), dish.getName(), dish.getPrice());
    }*/

    public static User createFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail(), userTo.getPassword(), Role.USER);
    }

}
