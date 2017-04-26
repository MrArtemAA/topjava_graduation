package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Areshko-AA on 24.04.2017.
 */
public interface UserService extends BaseService<User> {

    User getByEmail(String email) throws NotFoundException;

}
