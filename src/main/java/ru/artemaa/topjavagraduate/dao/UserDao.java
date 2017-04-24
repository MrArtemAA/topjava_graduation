package ru.artemaa.topjavagraduate.dao;

import ru.artemaa.topjavagraduate.model.User;

import java.util.List;

/**
 * Created by Areshko-AA on 24.04.2017.
 */
public interface UserDao extends BaseDao<User> {

    List<User> getByEmail();

}
