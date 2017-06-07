package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.artemaa.topjavagraduate.dao.UserDao;
import ru.artemaa.topjavagraduate.model.User;

/**
 * MrArtemAA
 * 07.06.2017
 */
@Repository
public class DataJpaUserDao extends DataJpaBaseDao<User, CrudUserJpaRepository> implements UserDao {
    private static final Sort SORT_BY_NAME_EMAIL = new Sort("name", "email");

    @Override
    protected Sort getSort() {
        return SORT_BY_NAME_EMAIL;
    }

    @Override
    public User getByEmail(String email) {
        return crudJpaRepository.getByEmail(email);
    }
}
