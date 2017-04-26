package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.dao.BaseDao;
import ru.artemaa.topjavagraduate.dao.UserDao;
import ru.artemaa.topjavagraduate.model.User;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFound;

import java.util.List;

/**
 * Created by Areshko-AA on 26.04.2017.
 */
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
