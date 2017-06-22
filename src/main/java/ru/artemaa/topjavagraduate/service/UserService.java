package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.to.UserTo;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.List;

/**
 * @author Artem Areshko
 * 24.04.2017
 */
public interface UserService {

    User get(int id) throws NotFoundException;

    User save(User user);

    void update(User user) throws NotFoundException;

    void update(UserTo userTo) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<User> getAll();

    User getByEmail(String email) throws NotFoundException;

}
