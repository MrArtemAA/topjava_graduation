package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.dao.UserDao;
import ru.artemaa.topjavagraduate.model.User;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFound;

/**
 * MrArtemAA
 * 26.04.2017
 */
//@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {

    public UserServiceImpl(UserDao dao) {
        super(dao);
    }

    @Override
    public User getByEmail(String email) {
        // TODO Assert enmail not null
        return checkNotFound(dao.getByEmail(email), "email=" + email);
    }

}
