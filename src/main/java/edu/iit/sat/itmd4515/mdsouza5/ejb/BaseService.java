/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mervin
 * @param <T>
 */
public abstract class BaseService<T> {

    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager entityManager;

    private final Class<T> entityClass;

    /**
     *
     * @param entityClass
     */
    protected BaseService(Class entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *
     * @param entity
     */
    public void create(T entity) {
        entityManager.persist(entity);
    }

    /**
     *
     * @param entity
     */
    public void update(T entity) {
        entityManager.merge(entity);
    }

    /**
     *
     * @param entity
     */
    public void remove(T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    /**
     *
     * @param id
     * @return
     */
    public T find(Long id) {
        return entityManager.find(entityClass, id);
    }

    /**
     *
     * @return
     */
    public abstract List<T> findAll();

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
