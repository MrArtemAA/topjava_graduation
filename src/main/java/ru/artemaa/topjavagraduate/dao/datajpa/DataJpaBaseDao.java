package ru.artemaa.topjavagraduate.dao.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import ru.artemaa.topjavagraduate.dao.BaseDao;
import ru.artemaa.topjavagraduate.model.BaseEntity;

import java.util.List;

/**
 * @author MrArtemAA
 *         18.05.2017
 */
public abstract class DataJpaBaseDao<Entity extends BaseEntity, CrudJpaRepository extends CrudBaseJpaRepository<Entity>> implements BaseDao<Entity> {
    protected static final Sort SORT_BY_NAME = new Sort("name");

    @Autowired
    protected CrudJpaRepository crudJpaRepository;

    public Entity save(Entity entity) {
        return crudJpaRepository.save(entity);
    }

    @Override
    public Entity get(int id) {
        return crudJpaRepository.findOne(id);
    }

    @Override
    public boolean delete(int id) {
        return crudJpaRepository.delete(id) != 0;
    }

    @Override
    public List<Entity> getAll() {
        return crudJpaRepository.findAll(getSort());
    }

    protected abstract Sort getSort();

}
