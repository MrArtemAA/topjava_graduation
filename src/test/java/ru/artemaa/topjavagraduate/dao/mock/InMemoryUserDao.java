package ru.artemaa.topjavagraduate.dao.mock;

import org.springframework.stereotype.Repository;
import ru.artemaa.topjavagraduate.dao.UserDao;
import ru.artemaa.topjavagraduate.model.User;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.artemaa.topjavagraduate.UserTestData.ADMIN;
import static ru.artemaa.topjavagraduate.UserTestData.USER;

/**
 * MrArtemAA
 * 03.05.2017
 */
@Repository
public class InMemoryUserDao extends InMemoryBaseDao<User> implements UserDao {

    public InMemoryUserDao() {
        byId.put(USER.getId(), USER);
        byId.put(ADMIN.getId(), ADMIN);
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("Get User by Email = {}", email);
        return byId.values().stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected AtomicInteger getCounter() {
        return new AtomicInteger(2);
    }

    @Override
    protected Comparator<User> getComparator() {
        return Comparator.comparing(User::getName).thenComparing(User::getEmail);
    }

}
