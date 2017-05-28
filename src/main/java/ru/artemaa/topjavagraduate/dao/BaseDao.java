package ru.artemaa.topjavagraduate.dao;

import ru.artemaa.topjavagraduate.model.BaseEntity;

import java.util.List;

/**
 * @author MrArtemAA
 * 24.04.2017
 */
public interface BaseDao<Entity extends BaseEntity> {

    Entity save(Entity entity);

    /**
     *
     * @param id
     * @return null if not found
     */
    Entity get(int id);

    /**
     *
     * @param id
     * @return false if not found
     */
    boolean delete(int id);

    List<Entity> getAll();

}
