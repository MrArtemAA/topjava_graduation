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

    public static final int REST1_ID = 1;//START_SEQ + 2;
    public static final int REST2_ID = 2;//START_SEQ + 3;

    public static final Restaurant REST1 = new Restaurant(REST1_ID, "Прага");
    public static final Restaurant REST2 = new Restaurant(REST2_ID, "У Дяди Федора");

    public static final List<Restaurant> RESTAURANTS = Arrays.asList(REST1, REST2);

}
