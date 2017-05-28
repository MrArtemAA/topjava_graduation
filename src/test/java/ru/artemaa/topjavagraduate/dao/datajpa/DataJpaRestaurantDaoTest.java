package ru.artemaa.topjavagraduate.dao.datajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.artemaa.topjavagraduate.dao.RestaurantDao;
import ru.artemaa.topjavagraduate.model.Restaurant;

import java.util.Arrays;

import static ru.artemaa.topjavagraduate.RestaurantTestData.*;

/**
 * @author MrArtemAA
 *         18.05.2017
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db-test.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class DataJpaRestaurantDaoTest {

    @Autowired
    private RestaurantDao dao;

    @Test
    public void testSave() throws Exception {
        Restaurant restaurant = new Restaurant(null, "Friends and Family");
        Restaurant saved = dao.save(restaurant);
        MATCHER.assertCollectionEquals(Arrays.asList(saved, REST1, REST2), dao.getAll());
    }

    @Test
    public void testGet() throws Exception {
    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testGetAll() throws Exception {
    }

}