/*
 *Class:    AbstractFacade
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package cst8218.jasa0008.entity;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Contains logic for performing database operations on sprites using the entitymanager.                                       
 * @author Nathan Denyer
 * @version 1
 * @since 1.8
 * @see SpriteFacadeREST
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    
    /**
     * Initial constructor
     * @param entityClass 
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    
    /**
     * Create an entity from the parameter object
     * @param entity 
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }
    
    /**
     * Merge two entities together
     * @param entity 
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }
    
    /**
     * Remove an entity
     * @param entity 
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    /**
     * Find an entity based upon an id
     * @param id
     * @return the entity object if it was found
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    /**
     * Query the database for a list of all entities
     * @return List of all entities
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    /**
     * Find entities in the provided range
     * @param range
     * @return List of entities in the range
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    /**
     * Count the number of entities in the database
     * @return the number of entities in the database
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
