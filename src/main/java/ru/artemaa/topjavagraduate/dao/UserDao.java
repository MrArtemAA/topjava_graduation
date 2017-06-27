package ru.artemaa.topjavagraduate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.artemaa.topjavagraduate.model.User;

import java.util.List;

import static ru.artemaa.topjavagraduate.util.ModelUtil.SORT_BY_NAME_EMAIL;

/**
 * @author Artem Areshko
 * 24.04.2017
 */
@Repository
@Transactional(readOnly = true)
public interface UserDao extends JpaRepository<User, Integer> {

    @Transactional
    @Override
    User save(User s);

    @Override
    User findOne(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    default List<User> findAll() {
        return findAll(SORT_BY_NAME_EMAIL);
    }

    User findByEmail(String email);

}
