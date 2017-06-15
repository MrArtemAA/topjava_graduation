package ru.artemaa.topjavagraduate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.artemaa.topjavagraduate.dao.UserDao;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.List;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFound;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFoundWithId;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(dao.findOne(id), id);
    }

    @Override
    public User save(User user) {
        Assert.notNull(user, "user can't be null");
        return dao.save(user);
    }

    @Override
    public User update(User user) throws NotFoundException {
        Assert.notNull(user, "user can't be null");
        return checkNotFoundWithId(dao.save(user), user.getId());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(dao.delete(id) != 0, id);
    }

    @Override
    public List<User> getAll() {
        return dao.findAll();
    }

    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email can't be null");
        return checkNotFound(dao.findByEmail(email), "email=" + email);
    }

}
