package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.artemaa.topjavagraduate.model.BaseEntity;

import java.util.List;

/**
 * @author MrArtemAA
 * 18.05.2017
 */
@Transactional(readOnly = true)
public interface CrudBaseJpaRepository<Entity extends BaseEntity> extends JpaRepository<Entity, Integer> {

    @Transactional
    @Override
    <S extends Entity> S save(S s);

    @Override
    Entity findOne(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Entity e WHERE e.id=:id")
    int delete(@Param("id") int id);

    @Override
    List<Entity> findAll(Sort sort);

}
