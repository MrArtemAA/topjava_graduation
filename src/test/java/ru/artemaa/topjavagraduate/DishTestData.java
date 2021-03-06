package ru.artemaa.topjavagraduate;

import ru.artemaa.topjavagraduate.matcher.ModelMatcher;
import ru.artemaa.topjavagraduate.model.Dish;
import ru.artemaa.topjavagraduate.to.DishTo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static ru.artemaa.topjavagraduate.RestaurantTestData.REST1;
import static ru.artemaa.topjavagraduate.RestaurantTestData.REST2;
import static ru.artemaa.topjavagraduate.model.BaseEntity.START_SEQ;

/**
 * @author Artem Areshko
 * 08.06.2017
 */
public class DishTestData {
    public static final ModelMatcher<Dish> MATCHER = ModelMatcher.of(Dish.class);
    public static final ModelMatcher<DishTo> MATCHER_TO = ModelMatcher.of(DishTo.class);

    public static final int DISH1_REST1_ID = START_SEQ + 4;
    public static final int DISH1_REST2_ID = START_SEQ + 7;

    public static final Dish DISH1_REST1 = new Dish(DISH1_REST1_ID, "Fish", REST1, LocalDate.now(), 100);
    public static final Dish DISH2_REST1 = new Dish(DISH1_REST1_ID + 1, "Chips", REST1, LocalDate.now(), 50);
    public static final Dish DISH3_REST1 = new Dish(DISH1_REST1_ID + 2, "Water", REST1, LocalDate.now(), 10);
    public static final List<Dish> REST1_DISHES = Arrays.asList(DISH2_REST1, DISH1_REST1, DISH3_REST1);

    public static final Dish DISH1_REST2 = new Dish(DISH1_REST2_ID, "Soup", REST2, LocalDate.now(), 100);
    public static final Dish DISH2_REST2 = new Dish(DISH1_REST2_ID + 1, "Steak", REST2, LocalDate.now(), 250);
    public static final List<Dish> REST2_DISHES = Arrays.asList(DISH1_REST2, DISH2_REST2);

    public static Dish getNew() {
        return new Dish(null, "Juice", REST2, LocalDate.now(), 50);
    }
    public static DishTo getNewTo() {
        return new DishTo(null, "Juice", 50);
    }
    public static Dish getUpdated() {
        return new Dish(DISH1_REST1_ID + 2, "Still water", REST1, LocalDate.now(), 15);
    }
    public static DishTo getUpdatedTo() {
        return new DishTo(DISH1_REST1_ID + 2, "Still water", 15);
    }

}
