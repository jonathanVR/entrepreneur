package com.entrepreneur.startupweekend.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

public abstract class AbstractJpaDAO<T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Transactional
    public T findOne(final Long id) {
        return entityManager.find(clazz, id);
    }

    public T findOne(final String id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Transactional
    public void create(final T entity) {
        System.out.println("Persisting:::: " + entity);
        entityManager.persist(entity);
    }

    @Transactional
    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    @Transactional
    public List<T> find(String consulta){
        System.out.println("Ejecutando Query:::: "+consulta);
        Query query = entityManager.createQuery(consulta);
        List<T> resultList = query.getResultList();
        return resultList;
    }

    @Transactional
    public Object findOne(Class clazz, String id) {
        return entityManager.find(clazz, id);
    }
    
    @Transactional
    public Object findOne(Class clazz, Long id) {
        return entityManager.find(clazz, id);
    }
}