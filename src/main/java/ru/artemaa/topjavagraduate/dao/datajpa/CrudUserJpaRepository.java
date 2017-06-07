package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.artemaa.topjavagraduate.model.User;

/**
 * MrArtemAA
 * 07.06.2017
 */
public interface CrudUserJpaRepository extends CrudBaseJpaRepository<User> {

    User getByEmail(String email);

    @Override
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

}
