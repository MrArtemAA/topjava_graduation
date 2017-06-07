package ru.artemaa.topjavagraduate.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.artemaa.topjavagraduate.dao.UserDao;
import ru.artemaa.topjavagraduate.model.User;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFound;

/**
 * MrArtemAA
 * 26.04.2017
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {

    public UserServiceImpl(UserDao dao) {
        super(dao);
    }

    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email can't be null");
        return checkNotFound(dao.getByEmail(email), "email=" + email);
    }

}
