package com.entrepreneur.startupweekend.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

public abstract class AbstractJpaDAO {

   // private Class clazz;

    @PersistenceContext
    private EntityManager entityManager;

//    public final void setClazz(final Class<T> clazzToSet) {
//        this.clazz = clazzToSet;
//    }

    @Transactional
    public Serializable findOne(Class clazz,final Long id) {
        return (Serializable)entityManager.find(clazz, id);
    }

    public Serializable findOne(Class clazz,final String id) {
        return (Serializable)entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<Serializable> findAll(Class clazz) {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Transactional
    public void create(final Serializable entity) {
        System.out.println("Persisting:::: " + entity);
        entityManager.persist(entity);
    }

    @Transactional
    public Serializable update(final Serializable entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void delete(final Serializable entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public void deleteById(Class clazz, final long entityId) {
        final Serializable entity = findOne(clazz,entityId);
        delete(entity);
    }

    @Transactional
    public List<Serializable> find(String consulta){
        System.out.println("Ejecutando Query:::: "+consulta);
        Query query = entityManager.createQuery(consulta);
        List<Serializable> resultList = query.getResultList();
        return resultList;
    }

}