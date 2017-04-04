/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import edu.iit.sat.itmd4515.mdsouza5.domain.Administrator;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author mervin
 */
@Stateless
public class AdministratorService extends BaseService<Administrator> {

    /**
     *
     */
    public AdministratorService() {
        super(Administrator.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Administrator> findAll() {
        return getEntityManager().createNamedQuery("Administrator.findAll", Administrator.class).getResultList();
    }

    /**
     *
     * @param username
     * @return
     */
    public Administrator findByUsername(String username) {
        return getEntityManager().createNamedQuery("Administrator.findByUsername", Administrator.class)
                .setParameter("username", username)
                .getSingleResult();
    }

}
