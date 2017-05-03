package ru.artemaa.topjavagraduate.service;

import ru.artemaa.topjavagraduate.dao.BaseDao;
import ru.artemaa.topjavagraduate.model.BaseEntity;
import ru.artemaa.topjavagraduate.util.exception.NotFoundException;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNotFoundWithId;

import java.util.List;

/**
 * Created by Areshko-AA on 26.04.2017.
 */
public abstract class BaseServiceImpl<Entity extends BaseEntity, Dao extends BaseDao<Entity>> implements BaseService<Entity> {

    protected Dao dao;

    public BaseServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Entity get(int id) throws NotFoundException {
        return checkNotFoundWithId(dao.get(id), id);
    }

    @Override
    public Entity save(Entity entity) {
        // TODO Assert entity not null
        return dao.save(entity);
    }

    @Override
    public Entity update(Entity entity) throws NotFoundException {
        // TODO Assert entity not null
        return checkNotFoundWithId(dao.save(entity), entity.getId());
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(dao.delete(id), id);
    }

    @Override
    public List<Entity> getAll() {
        return dao.getAll();
    }
}