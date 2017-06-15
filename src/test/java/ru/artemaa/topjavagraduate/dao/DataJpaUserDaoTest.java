package ru.artemaa.topjavagraduate.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.artemaa.topjavagraduate.model.User;

import java.util.Arrays;
import java.util.Collections;

import static ru.artemaa.topjavagraduate.UserTestData.*;

/**
 * MrArtemAA
 * 07.06.2017
 */
public class DataJpaUserDaoTest extends AbstractDataJpaDaoTest {

    @Autowired
    private UserDao dao;

    @Test
    public void testGetByEmail() throws Exception {
        MATCHER.assertEquals(ADMIN, dao.findByEmail("admin@world.org"));
    }

    @Test
    public void testSave() throws Exception {
        User user = getNew();
        User saved = dao.save(user);
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, saved, USER), dao.findAll());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = getUpdated();
        User saved = dao.save(user);
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, saved), dao.findAll());
    }

    @Test
    public void testGet() throws Exception {
        MATCHER.assertEquals(USER, dao.findOne(USER_ID));
    }

    @Test
    public void testGetNotFound() throws Exception {
        Assert.assertNull(dao.findOne(1));
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(USER_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), dao.findAll());
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        Assert.assertFalse(dao.delete(1) != 0);
    }

    @Test
    public void testGetAll() throws Exception {
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER), dao.findAll());
    }

}