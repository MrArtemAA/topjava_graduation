package ru.artemaa.topjavagraduate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.artemaa.topjavagraduate.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Artem Areshko
 *         25.06.2017
 */
public class JpaUtil {

    @PersistenceContext
    private EntityManager em;

    public void clear2ndLevelHibernateCache() {
        getSessionFactory().getCache().evictAllRegions();
    }

    public void clear2ndLevelHibernateCache(Class<? extends BaseEntity> entityClass) {
        getSessionFactory().getCache().evict(entityClass);
    }

    private SessionFactory getSessionFactory() {
        Session s = (Session) em.getDelegate();
        return s.getSessionFactory();
    }

}
