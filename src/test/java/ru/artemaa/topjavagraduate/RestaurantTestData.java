package ru.artemaa.topjavagraduate;

import ru.artemaa.topjavagraduate.matcher.ModelMatcher;
import ru.artemaa.topjavagraduate.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import static ru.artemaa.topjavagraduate.model.BaseEntity.START_SEQ;

/**
 * Created by Areshko-AA on 03.05.2017.
 */
public class RestaurantTestData {
    public static final ModelMatcher<Restaurant> MATCHER = new ModelMatcher<>();

    public static final int REST1_ID = START_SEQ;
    public static final int REST2_ID = START_SEQ + 1;

    public static final Restaurant REST1 = new Restaurant(REST1_ID, "Прага");
    public static final Restaurant REST2 = new Restaurant(REST2_ID, "У Дяди Федора");

    public static final List<Restaurant> RESTAURANTS = Arrays.asList(REST1, REST2);

}
