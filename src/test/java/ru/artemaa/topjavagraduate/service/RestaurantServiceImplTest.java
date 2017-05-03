package ru.artemaa.topjavagraduate.service;

import org.junit.Before;
import org.junit.Test;
import ru.artemaa.topjavagraduate.dao.mock.InMemoryRestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.Arrays;

import static ru.artemaa.topjavagraduate.RestaurantTestData.*;

/**
 * Created by Areshko-AA on 03.05.2017.
 */
public class RestaurantServiceImplTest extends AbstractServiceTest {

    private RestaurantService service;

    @Before
    public void setUp() throws Exception {
        service = new RestaurantServiceImpl(new InMemoryRestaurantDao());
    }

    @Test
    public void testGet() throws Exception {
        Restaurant restaurant = service.get(REST1_ID);
        MATCHER.assertEquals(REST1, restaurant);
    }

    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(10);
    }

    @Test
    public void testSave() throws Exception {
        Restaurant newRestaurant = new Restaurant(null, "Новый ресторан");
        Restaurant restaurant = service.save(newRestaurant);
        newRestaurant.setId(restaurant.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(newRestaurant, REST1, REST2), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        Restaurant updated = new Restaurant(REST1);
        updated.setName("Пушкин");
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
        service.delete(10);
    }

    @Test
    public void testGetAll() throws Exception {
        MATCHER.assertCollectionEquals(RESTAURANTS, service.getAll());
    }

}