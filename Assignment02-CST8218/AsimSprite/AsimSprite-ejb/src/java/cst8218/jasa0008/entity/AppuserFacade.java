/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 *Class:    Appuser Facade
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package cst8218.jasa0008.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ajasa
 */
@Stateless
public class AppuserFacade extends AbstractFacade<Appuser> {

    @PersistenceContext(unitName = "AsimSprite-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppuserFacade() {
        super(Appuser.class);
    }
    
}
