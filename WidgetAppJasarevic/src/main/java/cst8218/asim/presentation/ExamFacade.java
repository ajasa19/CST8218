/*
040922815
 */
package cst8218.asim.presentation;

import cst8218.asim.buisness.WidgetSummer815;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ajasa
 */
@Stateless
public class ExamFacade extends AbstractFacade<WidgetSummer815> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamFacade() {
        super(WidgetSummer815.class);
    }
    
}
