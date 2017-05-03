package ru.artemaa.topjavagraduate.dao.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.artemaa.topjavagraduate.dao.BaseDao;
import ru.artemaa.topjavagraduate.model.BaseEntity;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * MrArtemAA
 * 03.05.2017
 */
public abstract class InMemoryBaseDao<Entity extends BaseEntity> implements BaseDao<Entity> {
    protected static final Logger LOG = LoggerFactory.getLogger(InMemoryBaseDao.class);

    protected Map<Integer, Entity> byId = new ConcurrentHashMap<>();
    private AtomicInteger counter;

    protected abstract AtomicInteger getCounter();

    @Override
    public Entity save(Entity entity) {
        LOG.info("Save entity {}", entity.toString());
        if (entity.isNew()) {
            entity.setId(getCounter().incrementAndGet());
        }
        byId.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Entity get(int id) {
        LOG.info("Get entity by id = {}", id);
        return byId.get(id);
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Delete entity by id = {}", id);
        return byId.remove(id) != null;
    }

    protected abstract Comparator<Entity> getComparator();

    @Override
    public List<Entity> getAll() {
        LOG.info("Get all entities");
        return byId.values().stream()
                .sorted(getComparator())
                .collect(Collectors.toList());
    }

}
