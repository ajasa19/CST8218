/*
 *Class:    SpriteFacade
 *Author    Asim Jasarevic
 *project:  Assignment 01
 *Purpose:  EJB handels instances of program passing functions by the sprite class off to the DB.
 */
package cst8218.jasa0008.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgk
 */
@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "AsimSprite-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}
