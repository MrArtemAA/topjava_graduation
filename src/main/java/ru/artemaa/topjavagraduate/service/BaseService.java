package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.model.BaseEntity;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;

import java.util.List;

/**
 * MrArtemAA
 * 26.04.2017
 */
public interface BaseService<Entity extends BaseEntity> {

    Entity get(int id) throws NotFoundException;

    Entity save(Entity entity);

    Entity update(Entity entity) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Entity> getAll();

}
