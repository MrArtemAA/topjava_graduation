package ru.artemaa.topjavagraduate.service;

import org.junit.Before;
import org.junit.Test;
import ru.artemaa.topjavagraduate.dao.mock.InMemoryUserDao;
import ru.artemaa.topjavagraduate.model.Role;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.Arrays;

import static org.junit.Assert.*;
import static ru.artemaa.topjavagraduate.UserTestData.*;

/**
 * Created by Areshko-AA on 03.05.2017.
 */
public class UserServiceImplTest extends AbstractServiceTest {

    private UserService service;

    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl(new InMemoryUserDao());
    }

    @Test
    public void get() throws Exception {
        User user = service.get(USER_ID);
        MATCHER.assertEquals(USER, user);
    }

    @Test
    public void getNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(10);
    }

    @Test
    public void getByEmail() throws Exception {
        User user = service.getByEmail("user@world.org");
        MATCHER.assertEquals(USER, user);
    }

    @Test
    public void getByEmailNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.getByEmail("nouser@world.org");
    }

    @Test
    public void save() throws Exception {
        User newUser = new User(null, "New User", "newuser@world.org", "newuser", Role.USER);
        User user = service.save(newUser);
        newUser.setId(user.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, newUser, USER), service.getAll());
    }

    @Test
    public void update() throws Exception {
        User updated = new User(USER);
        updated.setEmail("new@world.org");
        service.update(updated);
        MATCHER.assertEquals(updated, service.get(USER_ID));
    }

    @Test
    public void delete() throws Exception {
        service.delete(USER_ID);
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN), service.getAll());
    }

    @Test
    public void deleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(10);
    }

    @Test
    public void getAll() throws Exception {
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER), service.getAll());
    }

}