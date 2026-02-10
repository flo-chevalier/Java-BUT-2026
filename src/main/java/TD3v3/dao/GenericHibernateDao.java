package TD3v3.dao;

import TD3v3.outils.HibernateOutil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericHibernateDao<T> implements GenericDAO<T, Integer> {

    private final Class<T> persistentClass;

    public GenericHibernateDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    Session getSession() {
        return HibernateOutil.getSessionFactory().openSession();
    }

    @Override
    public T findById(final Integer id) {
        try (Session session = getSession()) {
            return session.find(persistentClass, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = getSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
            criteria.from(persistentClass);
            return session.createQuery(criteria).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T create(final T entity) {
        try (Session session = getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T update(final T entity) {
        try (Session session = getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(final T entity) {
        try (Session session = getSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
