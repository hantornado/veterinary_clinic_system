/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Expertise;

/**
 *
 * @author hanto
 */
@Stateless
public class ExpertiseFacade extends AbstractFacade<Expertise> {

    @PersistenceContext(unitName = "AVCS1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpertiseFacade() {
        super(Expertise.class);
    }
    
}
