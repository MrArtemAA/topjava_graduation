package ru.artemaa.topjavagraduate.dao.datajpa;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;

import java.util.Arrays;
import java.util.Collections;

import static ru.artemaa.topjavagraduate.RestaurantTestData.*;

/**
 * @author MrArtemAA
 *         18.05.2017
 */
public class DataJpaRestaurantDaoTest extends AbstractDataJpaDaoTest {

    @Autowired
    private RestaurantDao dao;

    @Test
    public void testSave() throws Exception {
        Restaurant restaurant = getNew();
        Restaurant saved = dao.save(restaurant);
        MATCHER.assertCollectionEquals(Arrays.asList(saved, REST1, REST2), dao.getAll());
    }

    @Test
    public void testGet() throws Exception {
        Restaurant restaurant = dao.get(REST1_ID);
        MATCHER.assertEquals(REST1, restaurant);
    }

    @Test
    public void testGetNotFound() throws Exception {
        Assert.assertNull(dao.get(1));
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(REST1_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(REST2), dao.getAll());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        Assume.assumeFalse(dao.delete(1));
    }

    @Test
    public void testGetAll() throws Exception {
        MATCHER.assertCollectionEquals(Arrays.asList(REST1, REST2), dao.getAll());
    }

}