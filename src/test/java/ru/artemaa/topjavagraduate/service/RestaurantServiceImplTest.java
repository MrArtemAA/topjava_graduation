package ru.artemaa.topjavagraduate.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.Arrays;

import static ru.artemaa.topjavagraduate.RestaurantTestData.*;

/**
 * @author MrArtemAA
 * 03.05.2017
 */
public class RestaurantServiceImplTest extends AbstractServiceTest {

    @Autowired
    private RestaurantService service;

    @Test
    public void testGet() throws Exception {
        Restaurant restaurant = service.get(REST1_ID);
        MATCHER.assertEquals(REST1, restaurant);
    }

    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(1);
    }

    @Test
    public void testSave() throws Exception {
        Restaurant newRestaurant = getNew();
        Restaurant restaurant = service.save(newRestaurant);
        newRestaurant.setId(restaurant.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(newRestaurant, REST1, REST2), service.getAll());
    }

    @Test
    public void testSaveNotValid() throws Exception {
        thrown.expect(DataIntegrityViolationException.class);
        Restaurant newRestaurant = getNew();
        newRestaurant.setName(null);
        service.save(newRestaurant);
    }

    @Test
    public void testUpdate() throws Exception {
        Restaurant updated = getUpdated();
        service.update(updated);
        MATCHER.assertEquals(updated, service.get(REST1_ID));
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(REST1_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(REST2), service.getAll());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(1);
    }

    @Test
    public void testGetAll() throws Exception {
        MATCHER.assertCollectionEquals(RESTAURANTS, service.getAll());
    }

}